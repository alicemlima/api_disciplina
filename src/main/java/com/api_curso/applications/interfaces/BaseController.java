package com.api_curso.applications.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @param <T>
 */
public interface BaseController<T> {
    @GetMapping
    ResponseEntity<Object> findAll();

    @GetMapping("/{id}")
    ResponseEntity<Object> findOne(@PathVariable Long id);

    @PostMapping
    ResponseEntity<Object> save(@RequestBody T request) throws Exception;

    @PutMapping("/{id}")
    ResponseEntity<Object> update(@PathVariable Long id, @RequestBody T request);

    @DeleteMapping("/{id}")
    ResponseEntity<Object> remove(@PathVariable Long id);
}
