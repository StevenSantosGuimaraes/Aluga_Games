package br.com.steven.alugames.service

import br.com.steven.alugames.model.InfoJogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    fun buscaJogo(id: String):InfoJogo {

        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val cliente: HttpClient = HttpClient.newHttpClient()
        val requisicao = HttpRequest.newBuilder().uri(URI.create(endereco)).build()
        val resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString())
        val json = resposta.body()

        val gson = Gson()
        val umInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return umInfoJogo

    }

}