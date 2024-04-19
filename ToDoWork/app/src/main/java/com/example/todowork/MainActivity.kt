package com.example.todowork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.todowork.database.TaskDatabase
import com.example.todowork.repository.TaskRepository
import com.example.todowork.viewmodel.TaskViewModel
import com.example.todowork.viewmodel.TaskViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var taskViewModel:TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

// Inicializacion de version 0.5.0
//        val boton: ImageButton = findViewById(R.id.imageButton4)
//        boton.setOnClickListener {
//            val intent: Intent = Intent(this,CreacionTicket::class.java)
//            startActivity(intent)
//        }
//        val dataBase = Room.databaseBuilder(this,DBPruebas::Class.java, "usuario").build()
//
//        dataBase.UserDao().insertUser(UserEntity(1,"Ryan","correo","clave"))
        setupViewModel()
        }
        private fun setupViewModel(){
            val taskRepository = TaskRepository(TaskDatabase(this))
            val viewModelProviderFactory = TaskViewModelFactory(application,taskRepository)
            taskViewModel = ViewModelProvider(this,viewModelProviderFactory)[TaskViewModel::class.java]

    }
}