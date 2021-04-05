package org.emartos.xssdetector.model.exceptions;

public abstract class XssDetectorException extends Exception {

    public XssDetectorException(String message) {
        super(message);
    }

    public XssDetectorException(String message, Throwable cause) {
        super(message, cause);
    }
}
