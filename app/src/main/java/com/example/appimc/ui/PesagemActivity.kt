package com.example.appimc.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.example.appimc.R
import java.time.LocalDate

class PesagemActivity : AppCompatActivity() {

    lateinit var editTextDataPesagem : EditText
    lateinit var spinnerNivelAtividade : Spinner
    lateinit var editTextPeso : EditText
    lateinit var buttonSalvar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesagem)

        supportActionBar!!.hide()

        editTextDataPesagem = findViewById(R.id.edit_text_data_pesagem)
        val dataHoje = LocalDate.now().toString()
        val dataHojeArray = dataHoje.split("-").toTypedArray()
        val dataHojeBrasil = dataHojeArray[2] + '/' + dataHojeArray[1] + '/' + dataHojeArray[0]
        editTextDataPesagem.setText(dataHojeBrasil)

        spinnerNivelAtividade = findViewById(R.id.spinner_niveil_atividade)
        editTextPeso = findViewById(R.id.edit_text_peso)

        buttonSalvar = findViewById(R.id.button_salvar)
        buttonSalvar.setOnClickListener {
            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
            val pesagem = arquivo.getString("pesagem","")
            val dataPesagem = arquivo.getString("data_pesagem", "")
            val nivelAtividade = arquivo.getString("nivel_atividade", "")

            val editor = arquivo.edit()
            editor.putString("pesagem", "$pesagem;${editTextPeso.text.toString()}")
            editor.putString("data_pesagem", "$dataPesagem;${LocalDate.now().toString()}")
            editor.putString("nível_atividade", "$nivelAtividade;${spinnerNivelAtividade.selectedItemPosition.toString()}")
            editor.apply()

            Toast.makeText(this, "DADOS SALVOS COM SUCESSO", Toast.LENGTH_LONG).show()

            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

    }

}