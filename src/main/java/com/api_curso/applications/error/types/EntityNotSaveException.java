package com.api_curso.applications.error.types;

public class EntityNotSaveException extends RuntimeException {
    public EntityNotSaveException() {
        super("Não foi possível salvar o objeto da classe ");
    }
    public EntityNotSaveException(String classErro) {
        super("Não foi possível salvar o objeto da classe " + classErro);
    }
}
