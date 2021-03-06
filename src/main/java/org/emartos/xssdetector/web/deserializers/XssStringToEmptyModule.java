package org.emartos.xssdetector.web.deserializers;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class XssStringToEmptyModule extends SimpleModule {

    public XssStringToEmptyModule() {
        super();
        addDeserializer(String.class, new XssStringJsonDeserializer());
    }
}
