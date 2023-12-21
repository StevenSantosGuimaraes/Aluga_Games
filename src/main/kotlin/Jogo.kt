package org.example

data class Jogo(val titulo:String, val capa:String) {

    val descricao = ""

    override fun toString(): String {
        return "Jogo (" +
                "\ntitulo: $titulo, " +
                "\ncapa: $capa, " +
                "\ndescricao: $descricao" +
                "\n)"
    }

}