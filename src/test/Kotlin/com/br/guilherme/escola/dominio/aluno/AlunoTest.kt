package com.br.guilherme.escola.dominio.aluno

import com.br.guilherme.shared.dominio.CPF
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class AlunoTest {
    private lateinit var aluno : Aluno

    @BeforeEach
    fun beforeEach(){
        val cpf: CPF = CPF("123.123.123-12")
        val nome: String = "Guilherme Diniz"
        val email: Email = Email("dinizdesousaguilherme@gmail.com")

        aluno = Aluno(cpf,
            nome,
            email,
        )
    }

    @Test
    fun deveriaPermiteAdicionarTelefone() {
        aluno.adicionarTelefone("11","123456789")
        assertEquals(1, aluno.telefones.size)
    }

    @Test
    fun deveriaPermiteAdicionar2Telefones() {
        aluno.adicionarTelefone("11", "123456789")
        aluno.adicionarTelefone("11","987654321")
        assertEquals(2, aluno.telefones.size)
    }

    @Test
    fun naoDeveriaPermitirAdicionar3Telefones() {
        assertThrows(IllegalArgumentException::class.java) {
            aluno.adicionarTelefone("11", "123456789")
            aluno.adicionarTelefone("11","987654321")
            aluno.adicionarTelefone("12","123456789")
        }

    }
}