package com.br.guilherme.escola.dominio.aluno

import com.br.guilherme.shared.dominio.CPF

interface RepositorioDeAlunos {
    
    fun matricular(aluno: Aluno)
    
    fun buscarPorCPF(cpf: CPF): Aluno

    fun listarTodosAlunosMatriculados(): List<Aluno>

}