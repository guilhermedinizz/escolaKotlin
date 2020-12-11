package com.br.guilherme.escola.aplicacao.aluno.matricular

import com.br.guilherme.shared.dominio.evento.PublicadorDeEventos
import com.br.guilherme.escola.dominio.aluno.AlunoMatriculado
import com.br.guilherme.escola.dominio.aluno.RepositorioDeAlunos


class MatricularAluno(private val repositorio: RepositorioDeAlunos, private var publicador: PublicadorDeEventos) {
    fun executa(dados: MatricularAlunoDto) {
        val novo = dados.criarAluno()
        repositorio.matricular(novo)

        val evento : AlunoMatriculado = AlunoMatriculado(novo.cpf)
        publicador.publicar(evento)
    }
}