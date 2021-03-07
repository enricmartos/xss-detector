package org.emartos.requestvalidator.service.xss;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;

@SpringBootTest
public class XssProcessorImplTest {
    private final XssProcessor xssProcessor;

    public XssProcessorImplTest() {
        this.xssProcessor = new XssProcessorImpl();
    }

    private static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                // Data with XSS code
                {"<script>alert('XSS Test')</script>Michael", true},
                {"onload='fooFunction()'Test", true}, {"eval(\"x + y + z\")", true},
                {"src='img/xss/test.jpg'", true},
                {"<iframe src=\"https://www.test.com\" />", true},
                {"<div style=\"width: 500;\">CSS</div>", true},
                {"<script>var testValue='50;</script>", true}, {"<div>Malicious html</div>", true},
                {"<input type=\"text\" value=\"test value\"/>", true},
                {"=cmd|'/C calc.exe'!A0", true},
                {"X5O!P%@AP[4\\PZX54(P^)7CC)7}$EICAR-XSS-ANTIVIRUS-TEST-FILE!$H+H*", true},
                {"X5O!P%@AP[4\\PZX54(P^)7CC)7}$EICAR-XSS-ANTIVIRUS-TEST-FILE!$H+H*", true},
                // Data without XSS code
                {"XssUsername", false}, {"XssUsername@email.com", false},
                {"08340", false}});
    }

    @ParameterizedTest
    @MethodSource("data")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        Boolean containsXss = xssProcessor.containsXss(input);

        Assertions.assertEquals(containsXss, expected);
    }

}
