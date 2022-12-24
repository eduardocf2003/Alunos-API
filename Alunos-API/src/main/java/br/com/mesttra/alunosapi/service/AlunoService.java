package br.com.mesttra.alunosapi.service;

import br.com.mesttra.alunosapi.dto.CriarAlunoDTO;
import br.com.mesttra.alunosapi.entity.Aluno;
import br.com.mesttra.alunosapi.exception.ErroDeNegocioException;
import br.com.mesttra.alunosapi.repository.AlunoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepo;

    public boolean inserirAluno(CriarAlunoDTO aluno) throws ErroDeNegocioException {

        Aluno alunoEntity = new Aluno();
        BeanUtils.copyProperties(aluno, alunoEntity);

        alunoRepo.save(alunoEntity);
        return true;
    }

    public Aluno buscaAluno(Long matricula) {
        Optional<Aluno> alunoBanco = alunoRepo.findById(matricula);
        if (alunoBanco.isPresent()) {
            return alunoBanco.get();
        }

        return null;
    }

    public List<Aluno> listaTodosAlunos() {
        return (List<Aluno>) alunoRepo.findAll();
    }

    public boolean alterarAluno(Aluno aluno) {
        if (!alunoRepo.existsById(aluno.getMatricula())) {
            return false;
        }
        alunoRepo.save(aluno);
        return true;
    }

    public boolean removerAluno(Long matricula) {
        if (!alunoRepo.existsById(matricula)) {
            return false;
        }
        alunoRepo.deleteById(matricula);
        return true;
    }

    public Aluno buscarPorCpf(String cpf) {
        Optional<Aluno> alunoBanco = alunoRepo.findByCpf(cpf);
        if (alunoBanco.isPresent()) {
            return alunoBanco.get();
        }
        return null;
    }

}
