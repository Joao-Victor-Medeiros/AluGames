package br.com.bcndeveight.aluragames.modelo

data class Jogo (
    val titulo: String,
    val capa: String
){
    var descricao:String? = null

    override fun toString(): String {
        return "br.com.bcndeveight.aluragames.modelo.Jogo(titulo:='$titulo' \n," +
                " capa:'$capa'\n," +
                " descricao:'$descricao'\n)"
    }
}