package com.api_curso.applications.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Interface responsável por agrupar os métodos base dos controllers
 * @param <T>
 */
public interface BaseController<T> {
    /**
     * Método responsável por listar todos os objetos do tipo T
     * @return ResponseEntity<List<T>
     */
    @GetMapping
    ResponseEntity<List<T>> findAll();

    /**
     * Método responsável por buscar um objeto do tipo T pelo id
     * @param id
     * @return ResponseEntity<T>
     */
    @GetMapping("/{id}")
    ResponseEntity<T> findOne(@PathVariable Long id);

    /**
     * Método responsável por criar um objeto do tipo T
     * @param request
     * @return ResponseEntity<T>
     */
    @PostMapping
    ResponseEntity<T> create(@RequestBody T request) throws Exception;

    /**
     * Método responsável por editar um objeto
     * @param id
     * @param request
     * @return
     */
    @PutMapping("/{id}")
    ResponseEntity<T> update(@PathVariable Long id, @RequestBody T request);

    /**
     * Método responsável por remover um objeto
     * @param id
     * @return ResponseEntity<Object>
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Object> remove(@PathVariable Long id);
}
