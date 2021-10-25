package com.example.appimc.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun convertStringToLocalDate(brazilDate: String) : LocalDate{

    val dateFormatterFromBrazil = DateTimeFormatter.ofPattern("dd/MM/YYYY")

    val localDateFormat = LocalDate.parse(brazilDate, dateFormatterFromBrazil)

    return localDateFormat
}