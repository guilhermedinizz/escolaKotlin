package com.br.guilherme.escola.dominio.aluno


import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CPFTest{
    @Test
    fun naoDeveAceitarOCPF() {
        Assertions.assertThrows(IllegalArgumentException::class.java
        ) { CPF(null) }
        Assertions.assertThrows(IllegalArgumentException::class.java
        ) { CPF("") }
        Assertions.assertThrows(IllegalArgumentException::class.java
        ) { CPF("14253451") }
    }

    @Test
    fun deveAceitaOCPF() {
        val numero = "123.123.123-12"
        val cpf = CPF(numero)
        Assertions.assertEquals(numero, cpf.numero)
    }
}