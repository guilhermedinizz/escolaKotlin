package com.br.guilherme.escola.dominio.aluno

interface CifradorDeSenha {

    fun cifrarSenha(senha: String): String

    fun validarSenhaCifrada(senhaCifrada: String, senha: String): Boolean
}