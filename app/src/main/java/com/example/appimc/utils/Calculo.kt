package com.example.appimc.utils

import android.content.Context

fun calcularImc(context: Context) : Double {

    val arquivo =
            context.getSharedPreferences(
                    "usuario", Context.MODE_PRIVATE)

    val pesos = arquivo.getString("pesagem", "")!!
            .split(";")
            .toTypedArray()
    val pesoAtual = pesos.last()

    val altura = arquivo.getFloat("altura", 0.0f)

    return (pesoAtual.toInt() / (altura * altura)).toDouble()
}

fun calcularNcd() : Double {

    return 0.0
}