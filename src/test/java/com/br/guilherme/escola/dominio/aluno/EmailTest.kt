package com.br.guilherme.escola.dominio.aluno

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class EmailTest{
    @Test
    fun naoDeveriaCriarEmailsComEnderecosInvalidos() {
        Assertions.assertThrows(IllegalArgumentException::class.java
        ) { Email(null) }
        Assertions.assertThrows(IllegalArgumentException::class.java
        ) { Email("") }
        Assertions.assertThrows(IllegalArgumentException::class.java
        ) { Email("EmailInvalido") }
    }

    @Test
    fun deveCriarEmails() {
        val endereco = "dinizdesousaguilherme@gmail.com"
        val email = Email(endereco)
        Assertions.assertEquals(endereco, email.email)
    }
}