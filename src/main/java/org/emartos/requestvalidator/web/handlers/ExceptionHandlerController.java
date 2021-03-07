package org.emartos.requestvalidator.web.handlers;

import org.emartos.requestvalidator.model.exceptions.InvalidFileException;
import org.emartos.requestvalidator.model.exceptions.XssInjectionDetectedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
* This class maps domain exceptions to correspondent HTTP status codes
*/
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(XssInjectionDetectedException.class)
    private ResponseEntity<String> xssInjectionDetectedExceptionHandler(final XssInjectionDetectedException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InvalidFileException.class)
    private ResponseEntity<String> invalidFileExceptionHandler(final InvalidFileException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
