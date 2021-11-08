package com.example.appimc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.appimc.R
import com.example.appimc.utils.autenticar

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()

        val textViewNovaConta = findViewById<TextView>(R.id.text_view_nova_conta)
        textViewNovaConta.setOnClickListener {
            val novaConta = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(novaConta)
        }


        val editTextEmail = findViewById<EditText>(R.id.edit_text_email)
        val editTextSenha = findViewById<EditText>(R.id.edit_text_senha)

        val buttonEntrar = findViewById<Button>(R.id.button_entrar)
        buttonEntrar.setOnClickListener {
            val autenticou = autenticar(editTextEmail.text.toString(), editTextSenha.text.toString(), this)
            if (autenticou){
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            } else{
                Toast.makeText(this, "EMAIL OU SENHA INVÁLIDOS", Toast.LENGTH_LONG).show()
            }
        }
    }
}