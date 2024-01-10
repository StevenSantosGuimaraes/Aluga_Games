package br.com.steven.alugames.main

import br.com.steven.alugames.model.Gamer
import br.com.steven.alugames.model.Jogo
import br.com.steven.alugames.service.ConsumoApi
import java.util.*


fun main() {

    val leitor = Scanner(System.`in`)

    val gamer = Gamer.criarGamer(leitor)
    println("Cadastro concluído com sucesso.")
    println(gamer)

    do {

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
            gamer.listaJogos.add(oJogo)
        }

        println("Deseja buscar um novo jogo? S/N")
        val resposta = leitor.nextLine()

    } while (resposta.equals("s", true))

    println("\nLista Inicial: ")
    println(gamer.listaJogos)

    println("\nLista Ordenada: ")
    gamer.listaJogos.sortBy {
        it?.titulo
    }
    gamer.listaJogos.forEach {
        println("Titulo: " + it?.titulo)
    }


    val listaFiltrada = gamer.listaJogos.filter {
        it?.titulo?.contains("batman", true) ?: false
    }
    println("\nFiltro:")
    println(listaFiltrada)

    println("\nDeseja excluir registros da Lista Inicial? S/N")
    val opcao = leitor.nextLine()
    if (opcao.equals("s", true)) {
        println(gamer.listaJogos)
        println("Informe a posição do jogo a ser descartado: (0...)")
        val posicao = leitor.nextInt()
        gamer.listaJogos.removeAt(posicao)
    }

    println("\nLista inicial atualizada:")
    println(gamer.listaJogos)

    println("\nBusca finalizada com sucesso.")

}
