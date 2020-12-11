package com.br.guilherme.escola.dominio.aluno

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

internal class TelefoneTest {


    @Test
    fun naoDeveriaCriarTelefoneComDDDsInvalidos() {
        Assertions.assertThrows(IllegalArgumentException::class.java
        ) { Telefone(null, "123456789") }
        Assertions.assertThrows(IllegalArgumentException::class.java
        ) { Telefone("", "123456789") }
        Assertions.assertThrows(IllegalArgumentException::class.java
        ) { Telefone("1", "123456789") }
    }

    @Test
    fun naoDeveriaCriarTelefoneComNumerosInvalidos() {
        Assertions.assertThrows(IllegalArgumentException::class.java
        ) { Telefone("11", null) }
        Assertions.assertThrows(IllegalArgumentException::class.java
        ) { Telefone("11", "") }
        Assertions.assertThrows(IllegalArgumentException::class.java
        ) { Telefone("11", "1") }
    }

    @Test
    fun DeveriaCriarTelefone() {
        val ddd = "11"
        val numero = "123456789"
        val telefone = Telefone(ddd, numero)
        Assertions.assertEquals(ddd, telefone.ddd)
        Assertions.assertEquals(numero, telefone.numero)
    }
}