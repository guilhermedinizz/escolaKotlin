package com.br.guilherme.escola.dominio.aluno

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FabricaDeAlunoTest {

    val nome = "Guilherme Diniz de Sousa"
    val cpf = "123.123.123-12"
    val email = "dinizdesousaguilherme@gmail.com"
    val aluno: FabricaDeAluno = FabricaDeAluno().comNomeCPFEmail(nome, cpf, email)


    @Test
    fun comNomeCPFEmail() {
        assertEquals(cpf, aluno.criar()?.cpf)
        assertEquals(nome, aluno.criar()?.nome)
        assertEquals(email, aluno.criar()?.email)
    }

}