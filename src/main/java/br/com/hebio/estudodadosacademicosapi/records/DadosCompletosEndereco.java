package br.com.hebio.estudodadosacademicosapi.records;

import br.com.hebio.estudodadosacademicosapi.model.Endereco;
import jakarta.validation.constraints.Pattern;

public record DadosCompletosEndereco(String rua, String numero, String complemento, String bairro, String cidade,
                                     @Pattern(regexp = "\\d{8}") String cep, String estado
) {
    public DadosCompletosEndereco(Endereco endereco) {
        this(endereco.getRua(), endereco.getNumero(), endereco.getComplemento(), endereco.getBairro(), endereco.getCidade(), endereco.getCep(), endereco.getEstado());
    }
}