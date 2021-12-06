package com.example.appimc.repository

import android.content.Context
import com.example.appimc.model.Pesagem

class PesagemRepository(var context: Context) {

    fun getListaPesagem(): List<Pesagem> {
        val listaPesagem = mutableListOf<Pesagem>()

        val dados = context.getSharedPreferences("usuario", Context.MODE_PRIVATE)

        val pesosString = dados.getString("pesagem", "")
        val dataPesagemString = dados.getString("data_pesagem", "")

        val pesos = pesosString!!.split(";").toTypedArray()
        val datas = dataPesagemString!!.split(";").toTypedArray()

        for (i in 0 until pesos.size - 1){
            val pesagem = Pesagem(datas[i], pesos[i].toInt())

            listaPesagem.add(pesagem)
        }

        return  listaPesagem
    }

}