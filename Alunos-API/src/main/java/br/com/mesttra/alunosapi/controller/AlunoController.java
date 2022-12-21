package br.com.mesttra.alunosapi.controller;

import br.com.mesttra.alunosapi.entity.Aluno;
import br.com.mesttra.alunosapi.repository.AlunoRepository;
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
    AlunoRepository alunoRepo;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public boolean inserirAluno(@RequestBody Aluno aluno) {
        this.alunoRepo.save(aluno);
        return true;
    }

    @GetMapping(path = "/{matricula}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Optional<Aluno> buscaAluno(@PathVariable Long matricula) {
        return this.alunoRepo.findById(matricula);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Aluno> buscaAlunos() {
        return (List<Aluno>) alunoRepo.findAll();
    }

    @DeleteMapping(path = "/{matricula}")
    public void deletarAluno(@PathVariable Long matricula) {
        this.alunoRepo.deleteById(matricula);
        return;
    }

    @GetMapping(path = "/{cpf}/buscar-cpf", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Optional<Aluno> buscaAlunoPorCpf(@PathVariable String cpf) {
        return this.alunoRepo.findByCpf(cpf);
    }

}
