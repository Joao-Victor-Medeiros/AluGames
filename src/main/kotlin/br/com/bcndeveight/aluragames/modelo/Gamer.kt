package br.com.bcndeveight.aluragames.modelo

import kotlin.random.Random
import java.lang.IllegalArgumentException
data class Gamer(val nome: String, var email: String) {
    var idInterno: String? = null
        private set
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criarIdInterno()
            }
        }

    constructor(nome: String, email: String, dataNascimento: String, usuario: String) :
            this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        this.criarIdInterno()
    }

    init {
        if(nome.isBlank()){
            throw IllegalArgumentException("Nome inválido")
        }
        this.email = validarEmail()
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', idInterno=$idInterno, dataNascimento=$dataNascimento, usuario=$usuario)"
    }

    fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String {
        val regex = Regex(pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }
    }
}
