// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
        } else {
            println("Usuário já matriculado nesta formação.")
        }
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        conteudos.remove(conteudo)
    }

    fun obterConteudoPorNome(nome: String): ConteudoEducacional? {
        return conteudos.find { it.nome == nome }
    }
}

fun main() {
    val usuario1 = Usuario()
    val usuario2 = Usuario()

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)

    val formacao = Formacao("Desenvolvimento Kotlin", mutableListOf(conteudo1, conteudo2))

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario1) // Tentativa de matricular usuário1 novamente (deve exibir mensagem)

    println("Inscritos na formação ${formacao.nome}: ${formacao.inscritos}")
    println("Conteúdos da formação ${formacao.nome}: ${formacao.conteudos}")

    val conteudoEncontrado = formacao.obterConteudoPorNome("Introdução ao Kotlin")
    println("Conteúdo encontrado: $conteudoEncontrado")
}
