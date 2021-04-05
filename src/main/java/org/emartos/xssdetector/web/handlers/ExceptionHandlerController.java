package org.emartos.xssdetector.web.handlers;

import org.emartos.xssdetector.model.exceptions.InvalidFileException;
import org.emartos.xssdetector.model.exceptions.XssInjectionException;
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
