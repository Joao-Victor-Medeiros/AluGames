package br.com.bcndeveight.aluragames.principal

import br.com.bcndeveight.aluragames.modelo.Jogo
import br.com.bcndeveight.aluragames.servico.ConsumoApi
import java.util.*

fun main(args: Array<String>) {
    val leitura = Scanner(System.`in`)
    println("Digite o código do jogo que deseja buscar:")
    val busca = leitura.nextLine()

    val buscaApi = ConsumoApi()
    val informacoesJogo = buscaApi.buscaJogo(busca)

    val jogo = Jogo(informacoesJogo.info.title, informacoesJogo.info.thumb)

    var meuJogo: Jogo? = null

    val resultado = runCatching {
        val jogo = Jogo(informacoesJogo.info.title, informacoesJogo.info.thumb)
    }

    resultado.onFailure { println("br.com.bcndeveight.aluragames.modelo.Jogo inexistente.Tente outro id") }

    resultado.onSuccess {
        println("Deseja inserir uma descricao personalizada? S/n")
        val opcao = leitura.nextLine()
        if (opcao.equals("s", true)) {
            println("Insira a descrição personalizada para o jogo")
            val descricao = leitura.nextLine()
            meuJogo?.descricao = descricao
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }
    }
}