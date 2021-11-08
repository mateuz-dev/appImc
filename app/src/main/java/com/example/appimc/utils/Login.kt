package com.example.appimc.utils

import android.content.Context
import android.widget.Toast

fun autenticar(email:String, senha:String, context: Context) : Boolean{
    val arquivo = context.getSharedPreferences("usuario", Context.MODE_PRIVATE)

    if(email == arquivo.getString("email", "") && senha == arquivo.getString("senha", "")){
        return true
    } else{
        return false
    }

}