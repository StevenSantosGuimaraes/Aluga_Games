package org.example

import InfoJogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

fun main() {

    val cliente: HttpClient = HttpClient.newHttpClient()
    val requisicao = HttpRequest.newBuilder().uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146")).build()
    val resposta = cliente.send(requisicao, BodyHandlers.ofString())
    val json = resposta.body()

    println("\n" + json)

    val gson = Gson()
    val umInfoJogo = gson.fromJson(json, InfoJogo::class.java)
    val umJogo = Jogo(umInfoJogo.info.title, umInfoJogo.info.thumb)

    println("\n" + umJogo)

}