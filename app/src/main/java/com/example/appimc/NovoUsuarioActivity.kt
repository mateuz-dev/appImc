package com.example.appimc

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import java.util.*

class NovoUsuarioActivity : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editNome: EditText
    lateinit var editProfissao: EditText
//    lateinit var editAltura: EditText
    lateinit var editDataNascimento: EditText

    lateinit var radioSexo: RadioGroup
    lateinit var radioButtonFeminino: RadioButton
    lateinit var radioButtonMasculino: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        supportActionBar!!.title = "PERFIL"

        editEmail = findViewById<EditText>(R.id.edit_text_email)
        editSenha = findViewById<EditText>(R.id.edit_text_senha)
        editNome = findViewById<EditText>(R.id.edit_text_nome)
        editProfissao = findViewById<EditText>(R.id.edit_text_profissao)
//        editAltura = findViewById<EditText>(R.id.edit_text_altura)
        editDataNascimento = findViewById<EditText>(R.id.edit_text_data_nascimento)

        radioSexo = findViewById<RadioGroup>(R.id.radio_group_sexo)
        radioButtonFeminino = findViewById<RadioButton>(R.id.radio_button_feminino)
        radioButtonMasculino = findViewById<RadioButton>(R.id.radio_button_masculino)


        // criando o Calendário
        val calendario = Calendar.getInstance()

        // determinar os dados (dia / mês / ano)
        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        // abrir o componente Date Picker
        val etDataNascimento = findViewById<EditText>(R.id.edit_text_data_nascimento)
        etDataNascimento.setOnClickListener {
            val dp = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener{ view, _ano, _mes, _dia ->
                        etDataNascimento.setText("$_dia/${_mes + 1}/$_ano")
                    }, ano, mes, dia)

            dp.show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_perfil, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (validarCampos() && validarBotoes()){
            validarSenha()
            // envio banco de dados
        }

        val paginaLogin = Intent(this, LoginActivity::class.java)
        startActivity(paginaLogin)

        return true
    }


    fun validarCampos(): Boolean{

        if (editEmail.text.isEmpty()){
            editEmail.error = "O campo E-mail é obrigatório"
            return false
        } else if (editSenha.text.isEmpty()) {
            editSenha.error = "O campo Senha é Obrigatório"
            return false
        } else if (editNome.text.isEmpty()){
            editNome.error = "O Nome é Obrigatório"
            return false
        } else if (editProfissao.text.isEmpty()){
            editProfissao.error = "O campo Profissão é Obrigatório"
            return false
        } else if (editDataNascimento.text.isEmpty()){
            editDataNascimento.error = "O campo Data de Nascimento é Obrigatório"
            return false
        }
        return true
    }


    fun validarBotoes(): Boolean{
        if (radioButtonFeminino.isChecked || radioButtonMasculino.isChecked){
            return true
        } else {
            radioButtonFeminino.error = "O campo Sexo é Obrigatório"
            return false
        }
        return true
    }


    fun validarSenha(): Boolean{
        if (editSenha.text.length < 8 || editSenha.text.length > 12){
            editSenha.error = "A senha deve ter entre 8 a 12 caracteres"
            return false
        } else{
            return true
        }
    }
}