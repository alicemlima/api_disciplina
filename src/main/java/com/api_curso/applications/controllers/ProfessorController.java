package com.api_curso.applications.controllers;

import com.api_curso.applications.interfaces.BaseController;
import com.api_curso.domain.entities.Aluno;
import com.api_curso.domain.entities.Disciplina;
import com.api_curso.domain.entities.Professor;
import com.api_curso.applications.error.types.EntityNotFoundException;
import com.api_curso.domain.repositories.AlunoRepository;
import com.api_curso.domain.repositories.DisciplinaRepository;
import com.api_curso.domain.repositories.ProfessorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequestController
@RequestMapping("/professor")
public class ProfessorController implements BaseController<Professor> {
    @Autowired
    private ProfessorRepository professorRepository;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<Professor>> findAll() {
        List<Professor> professor = professorRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(professor);
    }

    /**
     * {@inheritDoc}
     */
     @Override
     public ResponseEntity<Professor> findOne(Long id) {
         Professor professor = professorRepository
         .findById(id)
         .orElseThrow(() -> new EntityNotFoundException(Professor.class.getSimpleName()));
        return ResponseEntity.status(HttpStatus.OK).body(professor);
     }

	@Override
	public ResponseEntity<Professor> create(Professor request) throws Exception {
        boolean professorExists = professorRepository.findByNome(request.getNome()).isPresent();
        if(professorExists) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new Professor());
        }
        Optional<Professor> professor = Optional.of(professorRepository.save(request));
		return ResponseEntity.status(HttpStatus.CREATED).body(professor.get());
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public ResponseEntity<Professor> update(Long id, Professor request) {
		Professor professor = professorRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Professor.class.getSimpleName()));
        BeanUtils.copyProperties(request, professor, "id");
        Optional<Professor> ProfessorUpdate = Optional.of(professorRepository.save(professor));
		return ResponseEntity.status(HttpStatus.CREATED).body(ProfessorUpdate.get());
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public ResponseEntity<Object> remove(Long id) {
		Professor professor = professorRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Professor.class.getSimpleName()));
        professorRepository.delete(professor);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor removido.");
	}
}