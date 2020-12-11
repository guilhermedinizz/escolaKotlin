package com.br.guilherme.escola.aplicacao.indicacao

import com.br.guilherme.escola.dominio.aluno.Aluno

interface EnviarEmailIndicacao {

    fun enviarPara(indicado: Aluno)
}