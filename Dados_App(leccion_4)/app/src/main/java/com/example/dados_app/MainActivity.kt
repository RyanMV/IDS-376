package com.example.dados_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
            rollButton.setOnClickListener {
                lanzarDados()

                rollButton.animate().setDuration(20).rotationBy(180f).start()
            }
    }
    private fun lanzarDados() {
        val dado = Dado(6)
        val notificacion = Toast.makeText(this, "!Boton presionado papá!!!", Toast.LENGTH_SHORT)
        notificacion.show()
        val resultTextView: TextView = findViewById(R.id.lblnumero)

        resultTextView.text = dado.roll().toString()
        val dadoLanzado = dado.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.animate().setDuration(20).rotationBy(90f).start()
        when (dadoLanzado) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
    }
}