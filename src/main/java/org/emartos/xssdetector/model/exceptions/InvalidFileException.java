package org.emartos.xssdetector.model.exceptions;

public class InvalidFileException extends XssDetectorException {

    public InvalidFileException(String message) {
        super(message);
    }

    public InvalidFileException(String message, Throwable t) {
        super(message, t);
    }
}
