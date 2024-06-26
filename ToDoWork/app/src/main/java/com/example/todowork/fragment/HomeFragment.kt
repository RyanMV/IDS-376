package com.example.todowork.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.todowork.MainActivity
import com.example.todowork.R
import com.example.todowork.adapter.TaskAdapter
import com.example.todowork.databinding.FragmentHomeBinding
import com.example.todowork.model.TaskEntity
import com.example.todowork.viewmodel.TaskViewModel


class HomeFragment : Fragment(R.layout.fragment_home), SearchView.OnQueryTextListener, MenuProvider {

    private var homeBinding: FragmentHomeBinding? = null
    private val binding get() = homeBinding!!

    private lateinit var taskViewModel : TaskViewModel
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this,viewLifecycleOwner,Lifecycle.State.RESUMED)

        taskViewModel = (activity as MainActivity).taskViewModel

        binding.addTaskFab.setOnClickListener{
            it.findNavController().navigate((R.id.action_homeFragment_to_addTaskFragment))
        }
    }
    private fun updateUI(task:List<TaskEntity>?){
        if(task != null){
            if(task.isNotEmpty()){
                binding.emptyTaskImage.visibility = View.GONE
                binding.homeRecyclerView.visibility = View.VISIBLE

            }else{
                binding.emptyTaskImage.visibility = View.VISIBLE
                binding.homeRecyclerView.visibility = View.GONE
            }
        }
    }

    private fun setupHomeRecyclerView(){
        taskAdapter = TaskAdapter()
        binding.homeRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = taskAdapter
        }

        activity?.let{
            taskViewModel.getAllTask().observe(viewLifecycleOwner){
                task -> taskAdapter.differ.submitList(task)
                updateUI(task)
            }
        }
    }

    private fun getTaskById(query: String?){
        val searchQuery = "%$query"
        taskViewModel.getTaskById(searchQuery).observe(this) {list->
            taskAdapter.differ.submitList(list)
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }


    override fun onQueryTextChange(newText: String?): Boolean {
        if(newText != ""){
            getTaskById(newText)
        }
        return true
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.menu_base,menu)
        val menuSearch = menu.findItem(R.id.searchMenu).actionView as SearchView
        menuSearch.isSubmitButtonEnabled = false
        menuSearch.setOnQueryTextListener(this)
    }


    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return false
    }

}