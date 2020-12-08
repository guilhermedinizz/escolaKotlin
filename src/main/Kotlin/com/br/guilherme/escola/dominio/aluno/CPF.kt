package com.br.guilherme.escola.dominio.aluno

class CPF(cpf: String?) {
    val numero: String
    val regex1 = "^(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{14})\$".toRegex()


    init {
        if(cpf == null || !cpf.matches(regex1)) { throw IllegalArgumentException("CPF Invalido") }
        this.numero = cpf
    }
}


