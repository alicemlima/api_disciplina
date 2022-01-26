package com.api_curso.domain.repositories;

import com.api_curso.domain.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
