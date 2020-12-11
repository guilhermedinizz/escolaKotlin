package com.br.guilherme.escola.aplicacao.aluno

import org.junit.jupiter.api.Test
import com.br.guilherme.escola.aplicacao.aluno.matricular.MatricularAluno
import com.br.guilherme.escola.aplicacao.aluno.matricular.MatricularAlunoDto
import com.br.guilherme.shared.dominio.evento.PublicadorDeEventos
import com.br.guilherme.shared.dominio.CPF
import com.br.guilherme.escola.dominio.aluno.LogDeAlunoMatriculado
import com.br.guilherme.escola.dominio.aluno.RepositorioDeAlunos
import com.br.guilherme.escola.infra.aluno.RepositorioDeAlunosEmMemoria
import org.junit.jupiter.api.Assertions

internal class MatricularAlunoTest {
    @Test
    fun alunoDeveriaSerPersistido() {

        val publicado: PublicadorDeEventos = PublicadorDeEventos()
        publicado.adicionar(LogDeAlunoMatriculado())
        val repositorio: RepositorioDeAlunos = RepositorioDeAlunosEmMemoria()
        val useCase: MatricularAluno = MatricularAluno(repositorio, publicado)

        val nome = "Fulano"
        val cpf = "123.123.123-12"
        val email = "fulano@gmail.com"

        val dados: MatricularAlunoDto = MatricularAlunoDto(nome,
                cpf,
                email)

        useCase.executa(dados)

        val encontrado = repositorio.buscarPorCPF(CPF(cpf))
        Assertions.assertEquals(nome, encontrado.nome)
        Assertions.assertEquals(cpf, encontrado.cpf)
        Assertions.assertEquals(email, encontrado.email)
    }
}