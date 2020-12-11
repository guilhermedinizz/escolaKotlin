package com.br.guilherme.escola.dominio.aluno

import com.br.guilherme.shared.dominio.evento.Evento
import com.br.guilherme.shared.dominio.CPF
import com.br.guilherme.shared.dominio.evento.TipoDeEvento
import java.time.LocalDateTime
import java.util.*

class AlunoMatriculado(
    cpfDoAluno: CPF
) : Evento {
    var cpfDoAluno = cpfDoAluno
        private set(value) {
            field = value
        }


    private val momento: LocalDateTime = LocalDateTime.now()

    override fun momento(): LocalDateTime {
        return momento
    }

    override fun tipo(): TipoDeEvento {
        return TipoDeEvento.ALUNO_MATRICULADO
    }

    override fun informacoes(): Map<String, Objects> {
        return mapOf("cpf" to cpfDoAluno as Objects)
    }


}
