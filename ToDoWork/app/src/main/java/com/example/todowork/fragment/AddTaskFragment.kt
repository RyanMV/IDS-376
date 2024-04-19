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
import com.example.todowork.MainActivity
import com.example.todowork.R
import com.example.todowork.databinding.FragmentAddTaskBinding
import com.example.todowork.model.TaskEntity
import com.example.todowork.viewmodel.TaskViewModel


class AddTaskFragment : Fragment(R.layout.fragment_add_task), MenuProvider {

    private var addTaskBinding: FragmentAddTaskBinding? = null
    private val binding get() = addTaskBinding!!

    private lateinit var taskViewModel: TaskViewModel
    private lateinit var  addTaskView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        addTaskBinding = FragmentAddTaskBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this,viewLifecycleOwner, Lifecycle.State.RESUMED)

        taskViewModel = (activity as MainActivity).taskViewModel
        addTaskView = view
    }

    private fun saveTask(view: View){
        val taskTitle = binding.addTaskTitle.text.toString().trim()
        val descripcion = binding.addDescripcion.text.toString().trim()

        if(taskTitle.isNotEmpty()){
            val task = TaskEntity(0,taskTitle,descripcion,"18/04/2024","HIGH",true,1,"active")
            taskViewModel.addTask(task)
            Toast.makeText(addTaskView.context, "Tarea guardada", Toast.LENGTH_SHORT).show()
            view.findNavController().popBackStack(R.id.homeFragment,false)
        }
        else{
            Toast.makeText(addTaskView.context, "Tarea no guardada, favor verificar...", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.menu_add_task,menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId){
            R.id.saveMenu ->{
                saveTask(addTaskView)
                true
            }
            else ->
                false

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        addTaskBinding = null
    }
}
