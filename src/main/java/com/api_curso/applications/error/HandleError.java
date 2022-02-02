package com.api_curso.applications.error;

import com.api_curso.applications.error.response.ErrorResponse;
import com.api_curso.applications.error.types.EntityNotSaveException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

/**
 * Classe com o objetivo de capturar eventuais erros
 * @author Herlmanoel Fernandes Barbosa
 * @version 1.0.0
 */
@ControllerAdvice
public class HandleError extends ResponseEntityExceptionHandler {

    /**
     * Captura o erro e retorna o JSON
     * @param erro Objeto contendo a exceção lançada
     * @return ResponseEntity JSON contendo a mensagem de erro e data e horário do erro
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyExceptions(Exception erro) {
        String message = erro.getLocalizedMessage();
        if(message == null) {
            message = erro.toString();
        }
        ErrorResponse errorMessage = new ErrorResponse(LocalDateTime.now(), message);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> anyExceptions(Exception erro) {
        String message = erro.getLocalizedMessage();
        if(message == null) {
            message = erro.toString();
        }
        ErrorResponse errorMessage = new ErrorResponse(LocalDateTime.now(), message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(value = {EntityNotSaveException.class})
    public ResponseEntity<Object> notSaveException(Exception erro) {
        String message = erro.getLocalizedMessage();
        if(message == null) {
            message = erro.toString();
        }
        ErrorResponse errorMessage = new ErrorResponse(LocalDateTime.now(), message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
