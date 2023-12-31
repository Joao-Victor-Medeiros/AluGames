package br.com.bcndeveight.aluragames.principal

import br.com.bcndeveight.aluragames.modelo.Gamer
import br.com.bcndeveight.aluragames.modelo.Jogo
import br.com.bcndeveight.aluragames.servico.ConsumoApi
import utilitario.transformarEmIdade
import java.util.*

fun main(args: Array<String>) {
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro consluido com sucesso, dados do gamer: $gamer")
    println("Idade do gamer: " + gamer.dataNascimento?.transformarEmIdade())

    do {
        println("Digite um código de jogo para busca:")
        val busca = leitura.nextLine()

        val buscaApi = ConsumoApi()
        val informacoesJogo = buscaApi.buscaJogo(busca)

        var meuJogo: Jogo? = null

        val resultado = runCatching {
            meuJogo = Jogo(informacoesJogo.info.title, informacoesJogo.info.thumb)
        }

        resultado.onFailure { println("Jogo inexistente.Tente outro id") }

        resultado.onSuccess {
            println("Deseja inserir uma descricao personalizada? S/n")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", true)) {
                println("Insira a descrição personalizada para o jogo")
                val descricao = leitura.nextLine()
                meuJogo?.descricao = descricao
            } else {

                meuJogo?.descricao = "pesquisar no site oficial do jogo ${meuJogo?.titulo}"
            }

            gamer.jogosBuscados.add(meuJogo)
        }

        println("Deseja buscar um outro jogo? S/n")
        val resposta = leitura.nextLine()
    } while (resposta.equals("s", true))
    println("Jogos buscados:")
    println(gamer.jogosBuscados)

    println("\n Jogos ordenados por titulos: ")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach {
        println("Título: " + it?.titulo)
    }

    val filterByName = fun(name: String) {
        gamer.jogosBuscados.filter {
            it?.titulo?.contains(name, true) ?: false
        }
    }

    println("filtrando por nome")
    filterByName("batman")
    println("Busca finalizada com sucesso")
}