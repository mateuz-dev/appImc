package com.example.appimc.model

import java.time.LocalDate

data class Usuario(
    var id:Int,
    var nome:String,
    var email:String,
    var senha:String,
    var altura:Double,
    var dataNascimento:LocalDate,
    var profissao:String,
    var sexo:Char,
)