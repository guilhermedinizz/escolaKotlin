package com.br.guilherme.escola.dominio.aluno

import com.br.guilherme.shared.dominio.CPF
import java.util.*

class Aluno (
    cpf: CPF,
    nome: String,
    email: Email
) {
    var email = email
        private set
    var nome = nome
        private set
    var cpf = cpf
        private set

    private val senha: String = ""


    val telefones: MutableList<Telefone> = ArrayList()

    fun adicionarTelefone(ddd: String?, numero: String?): Aluno {
        if (telefones.size == 2) throw IllegalArgumentException("Numero maximo de telefones ja atingido!")

        telefones.add(Telefone(ddd, numero))

        return this
    }

}