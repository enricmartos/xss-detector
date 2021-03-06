package org.emartos.requestvalidator.model.exceptions;

public class InvalidRequestException extends RequestValidatorException {

    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException(String message, Throwable t) {
        super(message, t);
    }
}
