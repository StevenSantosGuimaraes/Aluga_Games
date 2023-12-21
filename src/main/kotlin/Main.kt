package org.example

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers


fun main() {

    val cliente: HttpClient = HttpClient.newHttpClient()
    val requisicao = HttpRequest.newBuilder().uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146")).build()
    val resposta = cliente.send(requisicao, BodyHandlers.ofString())
    val json = resposta.body()

    println(json)

}