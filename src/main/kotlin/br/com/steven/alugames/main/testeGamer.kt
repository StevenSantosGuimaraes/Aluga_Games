import br.com.steven.alugames.model.Gamer

fun main() {
    val gamer1 = Gamer(
        "esteven",
        "esteven@teste.com")
    println(gamer1)

    val gamer2 = Gamer(
        "Steven",
        "steven@teste.com",
        "01/01/2000",
        "s7even")
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "01/02/2000"
        it.usuario = "teste"
    }.also {
        println(gamer1.idInterno)
    }

    gamer1.usuario = "outro"
    println(gamer1.idInterno)

}
