package com.br.guilherme.escola.dominio.aluno

import com.br.guilherme.shared.dominio.evento.Evento
import com.br.guilherme.shared.dominio.evento.Ouvinte
import java.time.format.DateTimeFormatter

class LogDeAlunoMatriculado : Ouvinte() {

    override fun reageAo(evento: Evento){
        var momentoFormatado: String = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
        println(String.format("Aluno com CPF %s matriculado em: %s",((evento as AlunoMatriculado).cpfDoAluno.toString()), momentoFormatado))
    }



    override fun deveProcessar(evento: Evento): Boolean {
        return evento is AlunoMatriculado
    }
}

