enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val nivel: Nivel)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (usuario.nivel == nivel) {
            inscritos.add(usuario)
        } else {
            println("Usuário ${usuario.nome} não possui o nível necessário para esta formação.")
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 60)
    val conteudo2 = ConteudoEducacional("Kotlin Avançado", 120)
    val formacao = Formacao("Formação Kotlin", listOf(conteudo1, conteudo2), Nivel.INTERMEDIARIO)
    
    val usuario1 = Usuario("João", Nivel.BASICO)
    val usuario2 = Usuario("Maria", Nivel.INTERMEDIARIO)
    
    formacao.matricular(usuario1) // Output: Usuário João não possui o nível necessário para esta formação.
    formacao.matricular(usuario2)
    
    println(formacao.inscritos.size) // Output: 1
}