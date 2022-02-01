package com.api_curso.applications.interfaces;

import com.api_curso.domain.entities.Disciplina;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 *
 * @param <T>
 */
public interface BaseController<T> {
    @GetMapping
    ResponseEntity<List<T>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<T> findOne(@PathVariable Long id);

    @PostMapping
    ResponseEntity<T> create(@RequestBody T request) throws Exception;

    @PutMapping("/{id}")
    ResponseEntity<T> update(@PathVariable Long id, @RequestBody T request);

    @DeleteMapping("/{id}")
    ResponseEntity<Object> remove(@PathVariable Long id);
}
