package com.example.appimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

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
    }
}