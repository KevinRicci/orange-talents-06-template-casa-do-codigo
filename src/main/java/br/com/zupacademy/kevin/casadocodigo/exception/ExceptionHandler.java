package br.com.zupacademy.kevin.casadocodigo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FieldErrorRequest> handle(MethodArgumentNotValidException exception){

        List<FieldErrorRequest> errors = new ArrayList<>();
        exception.getFieldErrors().forEach(e ->{
            errors.add(new FieldErrorRequest(e.getField(), e.getDefaultMessage()));
        });

        return errors;
    }


}
