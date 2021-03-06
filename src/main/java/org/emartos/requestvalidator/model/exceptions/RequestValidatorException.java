package org.emartos.requestvalidator.model.exceptions;

public abstract class RequestValidatorException extends Exception {

    public RequestValidatorException(String message) {
        super(message);
    }

    public RequestValidatorException(String message, Throwable cause) {
        super(message, cause);
    }
}
