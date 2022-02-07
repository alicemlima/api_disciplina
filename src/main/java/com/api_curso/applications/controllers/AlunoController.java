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
@RequestMapping("/aluno")
public class AlunoController implements BaseController<Aluno> {
    @Autowired
    private AlunoRepository alunoRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> alunos = alunoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(alunos);
    }

    /**
     * {@inheritDoc}
     */
     @Override
     public ResponseEntity<Aluno> findOne(Long id) {
         Aluno aluno = alunoRepository
         .findById(id)
         .orElseThrow(() -> new EntityNotFoundException(Aluno.class.getSimpleName()));
        return ResponseEntity.status(HttpStatus.OK).body(aluno);
     }

	@Override
	public ResponseEntity<Aluno> create(Aluno request) throws Exception {
        boolean alunoExists = alunoRepository.findByNome(request.getNome()).isPresent();
        if(alunoExists) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new Aluno());
        }
        Optional<Aluno> aluno = Optional.of(alunoRepository.save(request));
		return ResponseEntity.status(HttpStatus.CREATED).body(aluno.get());
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public ResponseEntity<Aluno> update(Long id, Aluno request) {
		Aluno aluno = alunoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Aluno.class.getSimpleName()));
        BeanUtils.copyProperties(request, aluno, "id");
        Optional<Aluno> alunoUpdate = Optional.of(alunoRepository.save(aluno));
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoUpdate.get());
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public ResponseEntity<Object> remove(Long id) {
		Aluno aluno = alunoRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Aluno.class.getSimpleName()));
        alunoRepository.delete(aluno);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("aluno removido.");
	}

}