package org.emartos.requestvalidator.web.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.emartos.requestvalidator.model.exceptions.XssInjectionDetectedException;
import org.emartos.requestvalidator.model.xss.XssProcessor;
import org.emartos.requestvalidator.model.xss.XssProcessorImpl;

import java.io.IOException;


public class XssStringJsonDeserializer extends JsonDeserializer<String> {

    private static final String XSS_INJECTION_DETECTED_EXCEPTION_MESSAGE =
            "Xss injection detected during JSON deserialization";

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        XssProcessor xssProcessor = new XssProcessorImpl();
        String jsonValue = jsonParser.getValueAsString();
        boolean containsXss = xssProcessor.containsXss(jsonValue);
        if (containsXss) {
            throw new XssInjectionDetectedException(XSS_INJECTION_DETECTED_EXCEPTION_MESSAGE);
        }
        return jsonValue;
    }

}
