package com.example.propinastico

import android.os.Bundle
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.propinastico.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var vista: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vista = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vista.root)
        vista.button.setOnClickListener{ calcularPropina()}
    }

    private fun calcularPropina(){
        var valorPropina: EditText = findViewById(R.id.valor_propinas)
        var montoPropina: TextView = findViewById(R.id.monto_de_propina)
        var opcionesRadio: RadioGroup = findViewById(R.id.opciones_propina)
        var switch: Switch = findViewById(R.id.switch_redonde)
        val monto_propina = valorPropina.text.toString()
        val costo = monto_propina.toDouble()
        val porcentajePropina = when (opcionesRadio.checkedRadioButtonId) {
            R.id.excelente -> 0.20
            R.id.bueno -> 0.18
            else -> 0.15
        }
        var propina = porcentajePropina * costo
        val redondear = switch.isChecked
        if(redondear){
            propina = kotlin.math.ceil(propina)
        }
        val propinaFormateada = NumberFormat.getCurrencyInstance().format(propina)
        montoPropina.text = getString(R.string.monto_de_propina, propinaFormateada)
    }
}