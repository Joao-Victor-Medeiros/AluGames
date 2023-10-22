package br.com.bcndeveight.aluragames.modelo

import kotlin.random.Random

data class Gamer(val nome: String,var email:String){
    var idInterno:String? = null
    var dataNascimento:String? = null
    var usuario:String? = null

    constructor(nome: String, email:String, dataNascimento:String, usuario:String):
            this(nome, email){
                this.dataNascimento = dataNascimento
                this.usuario = usuario
                this.criarIdInterno()
            }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', idInterno=$idInterno, dataNascimento=$dataNascimento, usuario=$usuario)"
    }

    fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }
}
