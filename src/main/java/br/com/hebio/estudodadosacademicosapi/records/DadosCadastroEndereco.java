package br.com.hebio.estudodadosacademicosapi.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEndereco(

        @NotBlank
        String rua,

        @NotBlank
        String numero,

        String complemento,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        String estado
) {
}
