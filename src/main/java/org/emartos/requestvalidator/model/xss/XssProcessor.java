package org.emartos.requestvalidator.model.xss;

public interface XssProcessor {

    boolean containsXss(String value);

}
