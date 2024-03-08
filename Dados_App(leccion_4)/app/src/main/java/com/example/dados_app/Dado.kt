package com.example.dados_app

import android.widget.Toast

class Dado (private val numeroDeLados: Int) {
    fun roll(): Int {
        return (1..numeroDeLados).random()

    }
}