package br.com.hebio.estudodadosacademicosapi.records;

import br.com.hebio.estudodadosacademicosapi.enums.Curso;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DadosCadastroAluno(

        @NotBlank
        String nome,

        @NotBlank
        @Pattern(regexp = "\\d{9}")
        String matricula,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @Email
        @NotBlank
        String email,

        @Enumerated(EnumType.STRING)
        Curso curso,

        @Valid
        @NotNull
        DadosCadastroEndereco endereco
) {
}
