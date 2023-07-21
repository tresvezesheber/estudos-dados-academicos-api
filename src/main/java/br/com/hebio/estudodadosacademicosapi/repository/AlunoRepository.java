package br.com.hebio.estudodadosacademicosapi.repository;

import br.com.hebio.estudodadosacademicosapi.model.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    Page<Aluno> findAllByAtivoIsTrue(Pageable paginacao);
}
