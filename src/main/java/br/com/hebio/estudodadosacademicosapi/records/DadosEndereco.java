package br.com.hebio.estudodadosacademicosapi.records;

import br.com.hebio.estudodadosacademicosapi.model.Endereco;

public record DadosEndereco(String cidade, String estado) {

    public DadosEndereco(Endereco endereco) {
        this(endereco.getCidade(), endereco.getEstado());
    }
}
