package org.emartos.requestvalidator.model.exceptions;

public class InvalidFileException extends RequestValidatorException {

    public InvalidFileException(String message) {
        super(message);
    }

    public InvalidFileException(String message, Throwable t) {
        super(message, t);
    }
}
