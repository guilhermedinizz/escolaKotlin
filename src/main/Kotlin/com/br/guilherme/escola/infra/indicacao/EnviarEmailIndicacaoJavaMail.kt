package com.br.guilherme.escola.infra.indicacao

import com.br.guilherme.escola.aplicacao.indicacao.EnviarEmailIndicacao
import com.br.guilherme.escola.dominio.aluno.Aluno

class EnviarEmailIndicacaoJavaMail : EnviarEmailIndicacao {

    override fun enviarPara(indicado: Aluno) {
        // logica de envio de emails com a lib JAVA Mail
    }
}