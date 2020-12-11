package com.br.guilherme.gemificacao.dominio.selo

import com.br.guilherme.shared.dominio.CPF

interface RepositorioDeSelos {

    fun adicinonar(selo: Selo)
    fun selosDoAlunoDeCPF(cpf: CPF): List<Selo>
}