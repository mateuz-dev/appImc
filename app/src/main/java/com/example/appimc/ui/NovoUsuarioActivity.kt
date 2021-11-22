package com.example.appimc.ui

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.appimc.R
import com.example.appimc.model.Usuario
import com.example.appimc.utils.convertStringToLocalDate
import java.time.LocalDate
import java.util.*

class NovoUsuarioActivity : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editNome: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
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
        editAltura = findViewById<EditText>(R.id.edit_text_altura)
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

        editDataNascimento.setOnClickListener {
            val dpd = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener { view, _ano, _mes, _dia ->

                        var diaFinal = _dia
                        var mesFinal = _mes + 1

                        var mesString = "$mesFinal"
                        var diaString = "$diaFinal"

                        if (mesFinal < 10) {
                            mesString = "0$mesFinal"
                        }

                        if (diaFinal < 10) {
                            diaString = "0$diaFinal"
                        }

                        Log.i("xpto", _dia.toString())
                        Log.i("xpto", _mes.toString())

                        editDataNascimento.setText("$diaString/$mesString/$_ano")
                    }, ano, mes, dia
            )
            dpd.show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_perfil, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (validarCampos() && validarBotoes() && validarSenha()){

            val dataNascimento = convertStringToLocalDate(editDataNascimento.text.toString())

            val usuario = Usuario(
                    1,
                    editNome.text.toString(),
                    editEmail.text.toString(),
                    editSenha.text.toString(),
                    0,
                    editAltura.text.toString().toDouble(),
                    LocalDate.of(
                            dataNascimento.year,
                            dataNascimento.monthValue,
                            dataNascimento.dayOfMonth
                    ),
                    editProfissao.text.toString(),
                    if (radioButtonFeminino.isChecked){
                        'F'
                    } else{
                        'M'
                    }
            )

            val dados = getSharedPreferences("usuario", Context.MODE_PRIVATE)

            val editor = dados.edit()
            editor.putInt("id", usuario.id)
            editor.putString("nome", usuario.nome)
            editor.putString("email", usuario.email)
            editor.putString("senha", usuario.senha)
            editor.putInt("peso", usuario.peso)
            editor.putFloat("altura", usuario.altura.toFloat())
            editor.putString("dataNascimento", usuario.dataNascimento.toString())
            editor.putString("profissao", usuario.profissao)
            editor.putString("sexo", usuario.sexo.toString())
            editor.apply()


            // redirecionamento para tela de login
            val paginaLogin = Intent(this, LoginActivity::class.java)
            startActivity(paginaLogin)
        }

        Toast.makeText(this, "USUÁRIO CADASTRADO", Toast.LENGTH_LONG).show()
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