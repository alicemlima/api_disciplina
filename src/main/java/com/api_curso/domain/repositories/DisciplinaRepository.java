package com.api_curso.domain.repositories;

import com.api_curso.domain.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

    Optional<Disciplina> findByNome(String nome);

}
