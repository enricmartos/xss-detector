package org.emartos.requestvalidator.web.handlers;

import org.emartos.requestvalidator.model.exceptions.InvalidFileException;
import org.emartos.requestvalidator.model.exceptions.XssInjectionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
* This class maps domain exceptions to correspondent HTTP status codes
*/
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(XssInjectionException.class)
    private ResponseEntity<String> xssInjectionExceptionHandler(final XssInjectionException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InvalidFileException.class)
    private ResponseEntity<String> invalidFileExceptionHandler(final InvalidFileException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
