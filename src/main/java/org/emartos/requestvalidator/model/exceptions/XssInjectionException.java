package org.emartos.requestvalidator.model.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;


public class XssInjectionException extends JsonProcessingException {

    public XssInjectionException(String message) {
        super(message);
    }

}
