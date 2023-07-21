package br.com.hebio.estudodadosacademicosapi.repository;

import br.com.hebio.estudodadosacademicosapi.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
