package org.emartos.requestvalidator.model.xss;

public class XssProcessorImpl implements XssProcessor {

    @Override
    public boolean containsXss(String value) {

        return XssUtils.FILTER_PATTERNS.stream()
                .anyMatch(pattern -> pattern.matcher(value).find());
    }

}
