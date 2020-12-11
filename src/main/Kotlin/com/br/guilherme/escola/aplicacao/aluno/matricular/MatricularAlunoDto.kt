package com.br.guilherme.escola.aplicacao.aluno.matricular

import com.br.guilherme.escola.dominio.aluno.Aluno
import com.br.guilherme.shared.dominio.CPF
import com.br.guilherme.escola.dominio.aluno.Email

class MatricularAlunoDto {
    var nomeAluno: String = ""
        private set(value) {
            field = value
        }
    var cpfAluno: String = ""
        private set(value) {
            field = value
        }
    var emailAluno: String = ""
        private set(value) {
            field = value
        }

    constructor(nomeAluno: String, cpfAluno: String, emailAluno: String) {
        this.nomeAluno = nomeAluno
        this.cpfAluno = cpfAluno
        this.emailAluno = emailAluno
    }

    fun criarAluno(): Aluno {
        return Aluno(CPF(cpfAluno), nomeAluno, Email(emailAluno))
    }
}