package org.emartos.requestvalidator.service.xss;

public interface XssProcessor {

    boolean containsXss(String value);

}
