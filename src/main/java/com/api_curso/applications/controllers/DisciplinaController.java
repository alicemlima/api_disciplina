package com.api_curso.applications.controllers;

import com.api_curso.applications.interfaces.BaseController;
import com.api_curso.domain.entities.Disciplina;
import com.api_curso.domain.repositories.DisciplinaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class DisciplinaController implements BaseController<Disciplina> {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Override
    public ResponseEntity<Object> findAll() {
        List<Disciplina> disciplinas = disciplinaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(disciplinas);
    }

    @Override
    public ResponseEntity<Object> findOne(Long id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);

        if(!disciplina.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(disciplina);
    }

    @Override
    public ResponseEntity<Object> save(Disciplina request) {
        Optional<Disciplina> disciplina = Optional.of(disciplinaRepository.save(request));

        if(!disciplina.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível salvar");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(disciplina.get());
    }

    @Override
    public ResponseEntity<Object> update(Long id, Disciplina request) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);

        BeanUtils.copyProperties(request, disciplina.get(), "id");
        Optional<Disciplina> disciplinaUpdated = Optional.of(disciplinaRepository.save(disciplina.get()));

        if(!disciplinaUpdated.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível salvar");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaUpdated.get());
    }

    @Override
    public ResponseEntity<Object> remover(Long id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        if(!disciplina.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("elemento não encontrado");
        }
        disciplinaRepository.delete(disciplina.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
