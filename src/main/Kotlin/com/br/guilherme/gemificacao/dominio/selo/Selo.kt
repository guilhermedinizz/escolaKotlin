package com.br.guilherme.gemificacao.dominio.selo

import com.br.guilherme.shared.dominio.CPF

class Selo(
    cpfDoAluno: CPF,
    nome: String
) {

    var nome: String = nome
        private set

    var cpfDoAluno = cpfDoAluno
        private set



}