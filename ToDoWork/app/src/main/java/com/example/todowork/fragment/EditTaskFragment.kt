package com.example.todowork.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todowork.MainActivity
import com.example.todowork.R
import com.example.todowork.databinding.FragmentEditTaskBinding
import com.example.todowork.model.TaskEntity
import com.example.todowork.viewmodel.TaskViewModel

class EditTaskFragment : Fragment(R.layout.fragment_edit_task), MenuProvider {

    private var editTaskBinding: FragmentEditTaskBinding? = null
    private val binding get() = editTaskBinding!!

    private lateinit var taskViewModel: TaskViewModel
    private lateinit var currentTask: TaskEntity

    private val args: EditTaskFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        editTaskBinding = FragmentEditTaskBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this,viewLifecycleOwner, Lifecycle.State.RESUMED)

        taskViewModel = (activity as MainActivity).taskViewModel
        currentTask = args.task!!

        binding.editTaskTitle.setText(currentTask.title)
        binding.editTaskDesc.setText(currentTask.description)

        binding.editTaskFab.setOnClickListener{
            val taskTitle = binding.editTaskTitle.text.toString().trim()
            val taskDescription = binding.editTaskDesc.text.toString().trim()

            if(taskTitle.isNotEmpty()){
                val task = TaskEntity(currentTask.id,currentTask.title,currentTask.description,"18/04/2024","Alta",true,2,"Closed")
                taskViewModel.update(task)
                view.findNavController().popBackStack(R.id.homeFragment,false)
            }
            else{
                Toast.makeText(context,"Favor colocar titulo",Toast.LENGTH_SHORT)
            }
        }

    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.menu_edit_task,menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId){
                R.id.deleteMenu ->

                        true
                    else->false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        editTaskBinding = null
    }

}