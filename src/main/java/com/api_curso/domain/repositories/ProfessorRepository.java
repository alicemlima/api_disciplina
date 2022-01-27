package com.api_curso.domain.repositories;

import com.api_curso.domain.entities.Disciplina;
import com.api_curso.domain.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
