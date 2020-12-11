package com.br.guilherme.gemificacao.infra.selo

import com.br.guilherme.shared.dominio.CPF
import com.br.guilherme.gemificacao.dominio.selo.RepositorioDeSelos
import com.br.guilherme.gemificacao.dominio.selo.Selo
import java.util.stream.Collectors

class RepositorioDeSelosEmMemoria : RepositorioDeSelos {

    private val selos: MutableList<Selo> = ArrayList()

    override fun adicinonar(selo: Selo) {
        this.selos.add(selo)
    }

    override fun selosDoAlunoDeCPF(cpf: CPF): List<Selo> {
        return this.selos
            .stream()
            .filter{s -> s.cpfDoAluno.numero.equals(cpf.numero)}
            .collect(Collectors.toList())
    }
}