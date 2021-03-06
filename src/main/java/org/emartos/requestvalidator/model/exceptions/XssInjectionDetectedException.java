package org.emartos.requestvalidator.model.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;


public class XssInjectionDetectedException extends JsonProcessingException {

    public XssInjectionDetectedException(String message) {
        super(message);
    }

}
