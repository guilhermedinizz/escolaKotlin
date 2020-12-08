package com.br.guilherme.escola.dominio.indicacao

import com.br.guilherme.escola.dominio.aluno.Aluno
import com.br.guilherme.escola.dominio.aluno.FabricaDeAluno
import java.time.LocalDateTime

class Indicacao(val indicado: Aluno, val indicante: Aluno, var dataIndicacao: LocalDateTime) {
    val dataAtual: LocalDateTime = LocalDateTime.now()

    init {
        this.dataIndicacao = dataAtual
    }
}
