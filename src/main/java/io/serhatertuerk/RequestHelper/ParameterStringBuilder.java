package io.serhatertuerk.RequestHelper;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ParameterStringBuilder {

    /**
     * @see <a href="https://www.baeldung.com/java-http-request">java-http-request</a>
     * @param parameters The parameters to send the request with
     * @return formatted map
     */
    protected static String getParamsString(Map<String, String> parameters) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
            result.append("&");
        }

        String resultString = result.toString();
        return !resultString.isEmpty()
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;

    }
}
