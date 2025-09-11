package org.algorix.kinal_play.web.exception;

import org.algorix.kinal_play.dominio.exception.Error;
import org.algorix.kinal_play.dominio.exception.PeliculaNoExisteExpection;
import org.algorix.kinal_play.dominio.exception.PeliculaYaExisteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(PeliculaYaExisteException.class)
    public ResponseEntity<Error> handleException(PeliculaYaExisteException ex) {
        Error error = new Error("pelicula-ya-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(PeliculaNoExisteExpection.class)
    public ResponseEntity<Error> handleException(PeliculaNoExisteExpection ex) {
        Error error = new Error("pelicula-no-existe", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex) {
        List<Error> errores = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fielError -> {
           errores.add(new Error(fielError.getField(), fielError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex) {
        Error error = new Error("Error desconocido", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
