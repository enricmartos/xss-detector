package org.emartos.requestvalidator.model.xss;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class XssProcessorImplTest {
    private final String parameterValue;
    private final boolean expectedValue;
    private final XssProcessor xssProcessor;

    public XssProcessorImplTest(String rawParameterValue, boolean expectedValue) {
        this.parameterValue = rawParameterValue;
        this.expectedValue = expectedValue;
        this.xssProcessor = new XssProcessorImpl();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                // Data with XSS code
                {"<script>alert('Strands Test')</script>Michael", true},
                {"onload='fooFunction()'Test", true}, {"eval(\"x + y + z\")", true},
                {"src='img/strands/test.jpg'", true},
                {"<iframe src=\"https://www.test.com\" />", true},
                {"<div style=\"width: 500;\">CSS</div>", true},
                {"<script>var testValue='50;</script>", true}, {"<div>Malicious html</div>", true},
                {"<input type=\"text\" value=\"test value\"/>", true},
                {"=cmd|'/C calc.exe'!A0", true},
                {"X5O!P%@AP[4\\PZX54(P^)7CC)7}$EICAR-STANDARD-ANTIVIRUS-TEST-FILE!$H+H*", true},
                {"X5O!P%@AP[4\\PZX54(P^)7CC)7}$EICAR-STANDARD-ANTIVIRUS-TEST-FILE!$H+H*", true},
                // Data without XSS code
                {"StrandsUsername", false}, {"StrandsUsername@email.com", false},
                {"08340", false}});
    }

    @Test
    public void testContainsXss() {
        Boolean containsXss = xssProcessor.containsXss(parameterValue);

        assertEquals(containsXss, expectedValue);
    }

}
