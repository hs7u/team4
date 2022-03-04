package web.Exception.controller;

import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import web.Exception.Enum.ErrorEnumMessage;

@ControllerAdvice
public class ErrorController {
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleBadInput(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getCause();
        String check = cause.getMessage();
        String errorEx = Stream.of(ErrorEnumMessage.values()).filter(e -> check.contains(e.name()))
                                                    .findFirst()
                                                    .get()
                                                    .getType();
        return ResponseEntity.ok(errorEx);
    }
}
