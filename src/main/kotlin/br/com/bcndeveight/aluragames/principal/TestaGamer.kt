package br.com.bcndeveight.aluragames.principal

import br.com.bcndeveight.aluragames.modelo.Gamer

fun main() {
    val gamer = Gamer("Jaque", "jaque@gmail.com")
    println(gamer)
    val gamer2 = Gamer("Jeni", "jeni@gmail.com", "19/09/1992", "jeniblo")

    gamer.let {
        it.dataNascimento = "02/04/1993"
        it.usuario = "jackskywaler"
        it.idInterno = "jackskywaler1234"
    }

    println(gamer)
    println(gamer2)
}