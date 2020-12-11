package com.br.guilherme.gemificacao.aplicacao

import com.br.guilherme.gemificacao.dominio.selo.RepositorioDeSelos
import com.br.guilherme.gemificacao.dominio.selo.Selo
import com.br.guilherme.shared.dominio.CPF
import com.br.guilherme.shared.dominio.evento.Evento
import com.br.guilherme.shared.dominio.evento.Ouvinte
import com.br.guilherme.shared.dominio.evento.TipoDeEvento

class GeraSeloAlunoNovato(repositorioDeSelos: RepositorioDeSelos): Ouvinte() {

    private lateinit var repositorioDeSelos: RepositorioDeSelos


    override fun reageAo(evento: Evento) {
        var cpfDoAluno: CPF = evento.informacoes().get("cpf") as CPF
        var novato: Selo = Selo(cpfDoAluno, "Novato")
        repositorioDeSelos.adicinonar(novato)
    }

    override fun deveProcessar(evento: Evento): Boolean {
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO
    }
}