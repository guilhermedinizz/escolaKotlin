package com.br.guilherme.shared.dominio

class CPF(cpf: String?) {

    var numero: String = ""
        private set


    private val regex1 = "^(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{14})\$".toRegex()


    init {
        if(cpf == null || !cpf.matches(regex1)) { throw IllegalArgumentException("CPF Invalido") }
        this.numero = cpf
    }

    override fun toString(): String {
        return numero
    }


}


