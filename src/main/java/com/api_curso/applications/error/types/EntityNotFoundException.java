package com.api_curso.domain.error.types;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String classErro) {
        super("Não foi possível encontrar o objeto da classe " + classErro);
    }
}
