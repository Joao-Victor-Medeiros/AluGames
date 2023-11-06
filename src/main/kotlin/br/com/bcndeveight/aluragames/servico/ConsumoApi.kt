package br.com.bcndeveight.aluragames.servico

import br.com.bcndeveight.aluragames.modelo.InfoGamerJson
import br.com.bcndeveight.aluragames.modelo.InfoJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {
    fun buscaJogo(id: String): InfoJogo {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val client:HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder().uri(URI.create(endereco))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo
    }

    fun buscaGamers(): List<InfoGamerJson> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val client:HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder().uri(URI.create(endereco))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        val meuGamerTipo = object: TypeToken<List<InfoGamerJson>>() {}.type
        val listGamer:List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        return listGamer
    }
}