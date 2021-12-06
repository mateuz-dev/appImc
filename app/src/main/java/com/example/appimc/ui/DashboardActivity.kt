package com.example.appimc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.appimc.R
import com.example.appimc.repository.PesagemRepository
import com.example.appimc.utils.calcularIdade
import kotlin.math.log

class DashboardActivity : AppCompatActivity() {

    lateinit var buttonPesagem : RelativeLayout
    lateinit var buttonHistorico : RelativeLayout

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


        buttonPesagem = findViewById(R.id.button_pesagem)
        buttonPesagem.setOnClickListener {
            val pesagem = Intent(this, PesagemActivity::class.java)
            startActivity(pesagem)
        }


        buttonHistorico = findViewById(R.id.button_historico)
        buttonHistorico.setOnClickListener {
            val historico = Intent(this, HistoricoActivity::class.java)
            startActivity(historico)
        }

        carregarDashboard()

    }


    private fun carregarDashboard(){
        val arquivo = this.getSharedPreferences("usuario", MODE_PRIVATE)
        textViewNome.text = arquivo.getString("nome", "")
        textViewProfissao.text = arquivo.getString("profissao", "")
        textViewAltura.text = arquivo.getFloat("altura", 0.0f).toString()
        textViewIdade.text = calcularIdade(arquivo.getString("dataNascimento", "")!!).toString()

        // val bitmap = convertBase64ToBitmap(arquivo.getString("fotoPerfil", "")!!)ivPerfil.set
    }


}