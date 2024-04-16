package com.example.todowork

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.room.PrimaryKey
import androidx.room.Room
import com.example.todowork.entities.UserEntity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val boton: ImageButton = findViewById(R.id.imageButton4)
        boton.setOnClickListener {
            val intent: Intent = Intent(this,CreacionTicket::class.java)
            startActivity(intent)
        }
        val dataBase = Room.databaseBuilder(this,DBPruebas::Class.java, "usuario").build()

        dataBase.UserDao().insertUser(UserEntity(1,"Ryan","correo","clave"))
    }
}