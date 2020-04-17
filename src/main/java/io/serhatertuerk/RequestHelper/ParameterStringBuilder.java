package io.serhatertuerk.RequestHelper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class ParameterStringBuilder {

    /**
     * @see <a href="https://www.baeldung.com/java-http-request">java-http-request</a>
     * @param parameters The parameters to send the request with
     * @return formatted map
     */
    protected static String getParamsString(Map<String, String> parameters) {
        StringBuilder result = new StringBuilder();

        try {
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                result.append("&");
            }

            String resultString = result.toString();
            return resultString.length() > 0
                    ? resultString.substring(0, resultString.length() - 1)
                    : resultString;
        } catch (UnsupportedEncodingException ee) {
            ee.printStackTrace();
        }

        return result.toString();
    }
}
