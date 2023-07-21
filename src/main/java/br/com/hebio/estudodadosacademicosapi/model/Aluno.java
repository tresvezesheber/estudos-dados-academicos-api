package br.com.hebio.estudodadosacademicosapi.model;

import br.com.hebio.estudodadosacademicosapi.enums.Curso;
import br.com.hebio.estudodadosacademicosapi.records.DadosAtualizacaoAluno;
import br.com.hebio.estudodadosacademicosapi.records.DadosCadastroAluno;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String nome;

    @NotBlank
    @Pattern(regexp = "\\d{9}")
    private String matricula;

    @NotBlank
    @Pattern(regexp = "\\d{11}")
    private String cpf;

    @Email
    @NotBlank
    private String email;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    @NotNull
    private boolean ativo;

    @Valid
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Aluno (DadosCadastroAluno dados) {
        this.nome = dados.nome();
        this.matricula = dados.matricula();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.curso = dados.curso();
        this.ativo = true;
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoAluno dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.matricula() != null){
            this.matricula = dados.matricula();
        }
        if(dados.cpf() != null){
            this.cpf = dados.cpf();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.curso() != null){
            this.curso = dados.curso();
        }
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void exclui() {
        this.ativo = false;
    }
}
