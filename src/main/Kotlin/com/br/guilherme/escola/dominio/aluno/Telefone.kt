package com.br.guilherme.escola.dominio.aluno

class Telefone(ddd: String?, numero: String?) {
    val ddd: String
    val numero: String
    val regex1 = "\\d{2}".toRegex()
    val regex2 = "\\d{8}|\\d{9}".toRegex()

    init {
        if(ddd == null || numero == null) { throw IllegalArgumentException("DDD e numero não preenchidos")}
        if(!ddd.matches(regex1)) { throw IllegalArgumentException("DDD invalido")}
        if(!numero.matches(regex2)) { throw IllegalArgumentException("Numero invalido")}
        this.ddd = ddd
        this.numero = numero
    }
}