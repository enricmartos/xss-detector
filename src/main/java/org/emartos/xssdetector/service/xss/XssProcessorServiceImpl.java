package org.emartos.xssdetector.service.xss;

public class XssProcessorServiceImpl implements XssProcessorService {

    @Override
    public boolean containsXss(String value) {

        return XssUtils.FILTER_PATTERNS.stream()
                .anyMatch(pattern -> pattern.matcher(value).find());
    }

}
