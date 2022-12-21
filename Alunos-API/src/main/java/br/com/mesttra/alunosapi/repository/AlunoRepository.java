package br.com.mesttra.alunosapi.repository;

import br.com.mesttra.alunosapi.entity.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {

    Optional<Aluno> findByCpf(String cpf);

}
