package com.br.guilherme.escola.dominio.aluno

import java.util.*

class Aluno(var cpf: CPF, val nome: String,var email: Email) {

    private val telefones: MutableList<Telefone> = ArrayList()

    fun adicionarTelefone(ddd: String?, numero: String?) {
        telefones.add(Telefone(ddd, numero))
    }
}