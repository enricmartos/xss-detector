package org.emartos.requestvalidator.configuration.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyResolver {

    @Value("${file.allowed-media-types}")
    private String[] allowedMediaTypes;

    public String[] getAllowedMediaTypes() {
        return allowedMediaTypes;
    }
}
