package br.com.hebio.estudodadosacademicosapi.records;

import br.com.hebio.estudodadosacademicosapi.model.Aluno;
import br.com.hebio.estudodadosacademicosapi.enums.Curso;

public record DadosListagemAlunos(String nome, String matricula, String email, Curso curso, DadosEndereco endereco) {

    public DadosListagemAlunos(Aluno aluno) {
        this(
                aluno.getNome(),
                aluno.getMatricula(),
                aluno.getEmail(),
                aluno.getCurso(),
                new DadosEndereco(aluno.getEndereco().getCidade(), aluno.getEndereco().getEstado()));
    }
}
