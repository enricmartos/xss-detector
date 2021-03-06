package org.emartos.requestvalidator.model.mapper.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.emartos.requestvalidator.web.deserializer.XssStringToEmptyModule;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Implementation of a jackson mapper to add the Strands custom configuration to Spring MVC message
 * converters
 */
@Component
@Primary
public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper() {
        super();

        // Add XSS String to EMPTY deserializer
        final XssStringToEmptyModule xssStringToEmptyModule = new XssStringToEmptyModule();
        this.registerModule(xssStringToEmptyModule);
    }

}
