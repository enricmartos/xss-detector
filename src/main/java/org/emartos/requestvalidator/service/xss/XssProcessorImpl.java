package org.emartos.requestvalidator.service.xss;

public class XssProcessorImpl implements XssProcessor {

    @Override
    public boolean containsXss(String value) {

        return XssUtils.FILTER_PATTERNS.stream()
                .anyMatch(pattern -> pattern.matcher(value).find());
    }

}
