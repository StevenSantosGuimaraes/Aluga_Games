package br.com.steven.alugames.main

import br.com.steven.alugames.model.Jogo
import br.com.steven.alugames.service.ConsumoApi
import java.util.*


fun main() {

    val leitor = Scanner(System.`in`)
    println("Informe o código do jogo: ")
    val idBuscar = leitor.nextLine()

    val buscaApi = ConsumoApi()
    val resultadoJogo = buscaApi.buscaJogo(idBuscar)

    var oJogo: Jogo? = null

    val resultado = runCatching {
        oJogo = Jogo(resultadoJogo.info.title, resultadoJogo.info.thumb)
    }

    resultado.onFailure {
        println("Jogo inexistente, tente novamente!")
    }

    resultado.onSuccess {
        println("Deseja personalizar a descrição do jogo? (S/N)")
        val desejaDescricao =  leitor.nextLine()
        if (desejaDescricao.equals("s", true)) {
            println("Informe a descrição desejada: ")
            val novaDescricao = leitor.nextLine()
            oJogo?.descricao = novaDescricao
        } else {
            oJogo?.descricao = oJogo?.titulo
        }
        println("\n" + oJogo)
    }

}
