package utilitario

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformarEmIdade(): Int {
    val formater = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val idade: Int
    val dataNascimento = LocalDate.parse(this, formater)
    val hoje = LocalDate.now()
    idade = Period.between(dataNascimento, hoje).years

    return idade
}