package br.com.hebio.estudodadosacademicosapi.controller;

import br.com.hebio.estudodadosacademicosapi.model.Aluno;
import br.com.hebio.estudodadosacademicosapi.records.DadosAtualizacaoAluno;
import br.com.hebio.estudodadosacademicosapi.records.DadosBuscaAluno;
import br.com.hebio.estudodadosacademicosapi.records.DadosCadastroAluno;
import br.com.hebio.estudodadosacademicosapi.records.DadosListagemAlunos;
import br.com.hebio.estudodadosacademicosapi.repository.AlunoRepository;
import br.com.hebio.estudodadosacademicosapi.repository.EnderecoRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
@AllArgsConstructor
public class AlunoController {

    private final AlunoRepository alunoRepository;
    private final EnderecoRepository enderecoRepository;

    @GetMapping
    public Page<DadosListagemAlunos> listar(@PageableDefault(size = 4, sort = {"nome"}) Pageable paginacao) {
        return alunoRepository.findAllByAtivoIsTrue(paginacao).map(DadosListagemAlunos::new);
    }

    @GetMapping("/{id}")
    public DadosBuscaAluno buscar(@PathVariable int id) {
        return new DadosBuscaAluno(alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado")));
    }


    @PostMapping
    @Transactional
    public void cadastrar(@Valid @RequestBody DadosCadastroAluno dadosCadastroAluno) {
        alunoRepository.save(new Aluno(dadosCadastroAluno));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoAluno dadosAtualizacaoAluno) {
        Aluno aluno = alunoRepository.getReferenceById(dadosAtualizacaoAluno.id());
        aluno.atualizarInformacoes(dadosAtualizacaoAluno);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable int id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        aluno.exclui();
    }
}
