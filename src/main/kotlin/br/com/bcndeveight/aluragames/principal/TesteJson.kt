package br.com.bcndeveight.aluragames.principal

import br.com.bcndeveight.aluragames.servico.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()

    println(listaGamers)
}