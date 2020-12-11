package com.br.guilherme.escola.infra.aluno

import com.br.guilherme.escola.dominio.aluno.Aluno
import com.br.guilherme.shared.dominio.CPF
import com.br.guilherme.escola.dominio.aluno.RepositorioDeAlunos
import java.lang.IllegalArgumentException

class RepositorioDeAlunosEmMemoria : RepositorioDeAlunos{

    private var matriculados: MutableList<Aluno> = ArrayList()

    override fun matricular(aluno: Aluno) {
        matriculados.add(aluno)
    }

    override fun buscarPorCPF(cpf: CPF): Aluno {
        return matriculados.stream()
                .filter { a -> a.cpf.numero.equals(cpf.numero) }
                .findFirst()
                .orElseThrow { throw RuntimeException(IllegalArgumentException("Aluno não encontrado: ${cpf.numero}")) }
    }

    override fun listarTodosAlunosMatriculados(): List<Aluno> {
        return matriculados
    }
}