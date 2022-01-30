package com.api_curso.applications.interfaces;

import com.api_curso.domain.entities.Disciplina;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface BaseController<T> {
    @GetMapping
    public ResponseEntity<Object> findAll();

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable Long id);

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody T request) throws Exception;

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody T request);

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remove(@PathVariable Long id);
}
