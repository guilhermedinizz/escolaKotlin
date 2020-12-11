package com.br.guilherme.escola.infra.aluno

import com.br.guilherme.escola.dominio.aluno.*
import com.br.guilherme.shared.dominio.CPF
import java.lang.IllegalArgumentException
import java.sql.*

class RepositorioDeAlunosComJDBC(var connection: Connection) : RepositorioDeAlunos {

    override fun matricular(aluno: Aluno) {
        var sql = "INSERT INTO ALUNO VALUES(?, ?, ?)"
        var ps: PreparedStatement = connection.prepareStatement(sql)
        ps.setString(1, aluno.cpf.toString())
        ps.setString(2, aluno.nome)
        ps.setString(2, aluno.email.endereco)
        ps.execute()

        sql = "INSERT INTO TELEFONE VALUES(?, ?)"
        ps = connection.prepareCall(sql)
        for (telefone : Telefone in aluno.telefones) {
            ps.setString(1, telefone.ddd)
            ps.setString(2, telefone.numero)
            ps.execute()
        }

    }

    override fun buscarPorCPF(cpf: CPF): Aluno {
        var sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?"
        var ps: PreparedStatement = connection.prepareStatement(sql)
        ps.setString(1,cpf.numero)

        var rs: ResultSet = ps.executeQuery()
        var encontrou : Boolean = rs.next()
        if (!encontrou) {
            throw IllegalArgumentException("Aluno não Encontrado com o CPF: ${cpf.numero}")
        }

        val nome: String = rs.getString("nome")
        val email: Email = Email(rs.getString("email"))
        val encontrado : Aluno = Aluno(cpf, nome, email);

        val id : Long = rs.getLong("id")

        sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id =?"
        ps = connection.prepareStatement(sql)
        ps.setLong(1, id)
        rs = ps.executeQuery()
        while (rs.next()) {
            val ddd: String = rs.getString("ddd")
            val numero: String = rs.getString("numero")
            encontrado.adicionarTelefone(ddd, numero)
        }
        return encontrado
    }

    override fun listarTodosAlunosMatriculados(): List<Aluno> {
        var sql: String = "SELECT id, cpf, nome, email FROM ALUNO"
        var ps: PreparedStatement = connection.prepareStatement(sql)

        var rs: ResultSet = ps.executeQuery()

        var alunos: MutableList<Aluno> = ArrayList()

        while (rs.next()) {
            val cpf = CPF(rs.getString("cpf"))
            val nome: String = rs.getString("nome")
            val email = Email(rs.getString("email"))
            val aluno = Aluno(cpf,nome,email)

            val id: Long = rs.getLong("id")
            sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?"
            var psTelefone: PreparedStatement = connection.prepareStatement(sql)
            psTelefone.setLong(1,id)
            var rsTelefone: ResultSet = psTelefone.executeQuery()
            while (rsTelefone.next()) {
                val numero: String = rsTelefone.getString("numero")
                val ddd: String = rsTelefone.getString("ddd")
                aluno.adicionarTelefone(ddd, numero)
            }
            alunos.add(aluno)
        }
        return alunos;
    }
}