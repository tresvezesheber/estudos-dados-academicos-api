package br.com.hebio.estudodadosacademicosapi.records;

import br.com.hebio.estudodadosacademicosapi.model.Aluno;
import br.com.hebio.estudodadosacademicosapi.enums.Curso;

public record DadosBuscaAluno(String nome, String matricula, String email, Curso curso, DadosCompletosEndereco endereco) {

    public DadosBuscaAluno(Aluno aluno) {
        this(
                aluno.getNome(),
                aluno.getMatricula(),
                aluno.getEmail(),
                aluno.getCurso(),
                new DadosCompletosEndereco(aluno.getEndereco()));
    }
}
