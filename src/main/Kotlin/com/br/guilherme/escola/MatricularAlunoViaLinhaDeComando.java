package com.br.guilherme.escola;

import com.br.guilherme.escola.aplicacao.aluno.matricular.MatricularAluno;
import com.br.guilherme.escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import com.br.guilherme.shared.dominio.evento.PublicadorDeEventos;
import com.br.guilherme.escola.dominio.aluno.LogDeAlunoMatriculado;
import com.br.guilherme.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoViaLinhaDeComando {
    public static void main(String[] args) {
        String nome = "Fulano da Silva";
        String cpf = "123.123.123-12";
        String email = "guilherme@email.com";

        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());

        MatricularAluno matricularAluno = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicador);
        matricularAluno.executa(new MatricularAlunoDto(nome,cpf,email));

    }
}
