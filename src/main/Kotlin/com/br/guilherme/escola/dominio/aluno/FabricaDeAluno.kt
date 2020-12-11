package com.br.guilherme.escola.dominio.aluno

import com.br.guilherme.shared.dominio.CPF
import com.br.guilherme.escola.dominio.aluno.FabricaDeAluno as FabricaDeAluno

class FabricaDeAluno {
    private var aluno: Aluno? = null
    fun comNomeCPFEmail(nome: String?, cpf: String?, email: String?): FabricaDeAluno {
        aluno = Aluno(CPF(cpf), nome!!, Email(email))
        return this
    }

    fun comTelefone(ddd: String?, numero: String?): FabricaDeAluno {
        requireNotNull(aluno) { "Aluno não foi criado" }
        aluno!!.adicionarTelefone(ddd, numero)
        return this
    }

    fun criar(): Aluno? {
        return aluno
    }
}