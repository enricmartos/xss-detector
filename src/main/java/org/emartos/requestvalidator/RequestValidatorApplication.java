package org.emartos.requestvalidator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.emartos.requestvalidator.web.deserializer.XssStringToEmptyModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class RequestValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestValidatorApplication.class, args);
	}

//	@Bean
//    @Primary
//    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
//    ObjectMapper objectMapper = builder.createXmlMapper(false).build();
//    objectMapper.registerModule(new XssStringToEmptyModule());
//
//    return objectMapper;
//}

}
