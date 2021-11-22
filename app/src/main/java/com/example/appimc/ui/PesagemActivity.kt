package com.example.appimc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.EditText
import android.widget.TextView
import com.example.appimc.R
import com.example.appimc.utils.calcularIdade
import java.time.LocalDate

class PesagemActivity : AppCompatActivity() {

    lateinit var textViewNome : TextView
    lateinit var textViewProfissao : TextView
    lateinit var textViewImc : TextView
    lateinit var textViewNcd : TextView
    lateinit var textViewIdade : TextView
    lateinit var textViewAltura : TextView
    lateinit var textViewDataPesagem : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesagem)

        supportActionBar!!.title = "PESAGEM"

        textViewNome = findViewById(R.id.text_view_usuario_nome)
        textViewProfissao = findViewById(R.id.text_view_usuario_profissao)
        textViewImc = findViewById(R.id.text_view_usuario_imc)
        textViewNcd = findViewById(R.id.text_view_usuario_ncd)
        textViewIdade = findViewById(R.id.text_view_usuario_idade)
        textViewAltura = findViewById(R.id.text_view_usuario_altura)

        carregarDashboard()

        val dataHoje = LocalDate.now().toString()
        val dataHojeArray = dataHoje.split("-").toTypedArray()

        textViewDataPesagem = findViewById(R.id.edit_text_data_pesagem)
        textViewDataPesagem.text = dataHojeArray[2] + "/" + dataHojeArray[1] + "/" + dataHojeArray[0]
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_perfil, menu)
        return true
    }


    private fun carregarDashboard(){
        var arquivo = this.getSharedPreferences("usuario", MODE_PRIVATE)
        textViewNome.text = arquivo.getString("nome", "")
        textViewProfissao.text = arquivo.getString("profissao", "")
        textViewAltura.text = arquivo.getFloat("altura", 0.0f).toString()
        textViewIdade.text = calcularIdade(arquivo.getString("dataNascimento", "")!!).toString()

        // val bitmap = convertBase64ToBitmap(arquivo.getString("fotoPerfil", "")!!)ivPerfil.set
    }
}