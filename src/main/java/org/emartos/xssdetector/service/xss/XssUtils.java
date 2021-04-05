package org.emartos.xssdetector.service.xss;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class XssUtils {

    public static final List<Pattern> FILTER_PATTERNS = Collections.unmodifiableList(Arrays.asList(
            // Detect common html tags
            Pattern.compile("(<input(.*?)></input>|<input(.*)/>)", Pattern.CASE_INSENSITIVE), Pattern.compile("<span(.*?)</span>", Pattern.CASE_INSENSITIVE), Pattern.compile("<div(.*)</div>", Pattern.CASE_INSENSITIVE), Pattern.compile("<style>(.*?)</style>", Pattern.CASE_INSENSITIVE),
            // Detect onload= expressions
            Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                    | Pattern.DOTALL),
            // Detect anything between script tags
            Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
            // Detect javascript:... expressions
            Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
            // Detect any lonesome </script> tag
            Pattern.compile("</script>", Pattern.CASE_INSENSITIVE), Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE
                    | Pattern.MULTILINE | Pattern.DOTALL),
            // Detect anything in a src='...' expressions
            Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE
                    | Pattern.MULTILINE | Pattern.DOTALL), Pattern
                                                                  .compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE
                                                                          | Pattern.MULTILINE
                                                                          | Pattern.DOTALL),
            // Detect eval(...) expressions
            Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                    | Pattern.DOTALL), Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // Detect vbscript:... expressions
            Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
            // Detect commands execution expressions
            Pattern.compile("=cmd", Pattern.CASE_INSENSITIVE),
            // Detect EICAR Strings header
            Pattern.compile("X5O!P%@AP", Pattern.CASE_INSENSITIVE)

    ));

}
