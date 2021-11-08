package com.example.appimc.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.appimc.R

class DashboardActivity : AppCompatActivity() {

    lateinit var textViewNome : TextView
    lateinit var textViewProfissao : TextView
    lateinit var textViewImc : TextView
    lateinit var textViewNcd : TextView
    lateinit var textViewIdade : TextView
    lateinit var textViewAltura : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar!!.hide()

        textViewNome = findViewById(R.id.text_view_usuario_nome)
        textViewProfissao = findViewById(R.id.text_view_usuario_profissao)
        textViewImc = findViewById(R.id.text_view_usuario_imc)
        textViewNcd = findViewById(R.id.text_view_usuario_ncd)
        textViewIdade = findViewById(R.id.text_view_usuario_idade)
        textViewAltura = findViewById(R.id.text_view_usuario_altura)

        carregarDashboard()
    }


    private fun carregarDashboard(){
        var arquivo = this.getSharedPreferences("usuario", MODE_PRIVATE)
        textViewNome.text = arquivo.getString("nome", "")
        textViewProfissao.text = arquivo.getString("profissao", "")
        textViewAltura.text = arquivo.getFloat("altura", 0.0f).toString()

        val bitmap =
    }


}