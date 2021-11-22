package com.example.appimc.utils

import java.time.Duration
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun convertStringToLocalDate(brazilDate: String) : LocalDate {
    val dateFormatterFromBrazil = DateTimeFormatter
                .ofPattern("dd/MM/yyyy")

    val localDateFormat = LocalDate
                .parse(brazilDate, dateFormatterFromBrazil)

    return localDateFormat
}


fun calcularIdade(dataNascimento: String) : Int {
    val dataHoje = LocalDate.now()
    val dataNascimentoArray = dataNascimento.split("-").toTypedArray()
    val dataNascimento = LocalDate.of(dataNascimentoArray[0].toInt(), dataNascimentoArray[1].toInt(), dataNascimentoArray[2].toInt())
    val idade =  Period.between(dataNascimento, dataHoje).years
    return idade
}