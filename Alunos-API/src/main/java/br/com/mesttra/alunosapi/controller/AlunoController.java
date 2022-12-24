package br.com.mesttra.alunosapi.controller;

import br.com.mesttra.alunosapi.dto.CriarAlunoDTO;
import br.com.mesttra.alunosapi.entity.Aluno;
import br.com.mesttra.alunosapi.exception.ErroDeNegocioException;
import br.com.mesttra.alunosapi.repository.AlunoRepository;
import br.com.mesttra.alunosapi.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public boolean inserirAluno(@RequestBody @Valid CriarAlunoDTO aluno) throws ErroDeNegocioException {
        this.alunoService.inserirAluno(aluno);
        return true;
    }

    @GetMapping(path = "/{matricula}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Aluno buscaAluno(@PathVariable Long matricula) {
        return this.alunoService.buscaAluno(matricula);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Aluno> buscaAlunos() {
        return alunoService.listaTodosAlunos();
    }

    @DeleteMapping(path = "/{matricula}")
    public boolean deletarAluno(@PathVariable Long matricula) {
        return alunoService.removerAluno(matricula);
    }

    @GetMapping(path = "/{cpf}/buscar-cpf", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Aluno buscaAlunoPorCpf(@PathVariable String cpf) {
        return alunoService.buscarPorCpf(cpf);
    }

}
