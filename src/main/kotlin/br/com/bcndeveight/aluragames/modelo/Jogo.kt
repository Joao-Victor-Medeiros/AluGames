package br.com.bcndeveight.aluragames.modelo

data class Jogo (
    val titulo: String,
    val capa: String
){
    var descricao:String? = null

    override fun toString(): String {
        return buildString {
            append("titulo:='$titulo' \n,")
            append(" capa:'$capa'\n,")
            append(" descricao:'$descricao'\n)")
        }
    }
}