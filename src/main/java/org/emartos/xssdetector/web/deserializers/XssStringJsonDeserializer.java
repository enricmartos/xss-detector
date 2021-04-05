package org.emartos.xssdetector.web.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.emartos.xssdetector.model.exceptions.XssInjectionException;
import org.emartos.xssdetector.service.xss.XssProcessorService;
import org.emartos.xssdetector.service.xss.XssProcessorServiceImpl;

import java.io.IOException;


public class XssStringJsonDeserializer extends JsonDeserializer<String> {

    private static final String XSS_INJECTION_EXCEPTION_MESSAGE =
            "XSS injection during JSON deserialization";

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        XssProcessorService xssProcessorService = new XssProcessorServiceImpl();
        String jsonValue = jsonParser.getValueAsString();
        boolean containsXss = xssProcessorService.containsXss(jsonValue);
        if (containsXss) {
            throw new XssInjectionException(XSS_INJECTION_EXCEPTION_MESSAGE);
        }
        return jsonValue;
    }

}
