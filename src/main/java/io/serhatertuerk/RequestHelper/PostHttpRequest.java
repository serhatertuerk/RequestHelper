package io.serhatertuerk.RequestHelper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class PostHttpRequest extends ParameterStringBuilder {

    /**
     * Sends a POST request to a specific URL
     * @see <a href="https://www.baeldung.com/java-http-request">java-http-request</a>
     * @param str_url A url to send the request to
     * @param parameters The parameters to send the request with
     * @return response of the server
     */
    protected static String post_http_request_with_args(String str_url, Map<String, String> parameters) {

        HttpURLConnection con = null;

        try {
            URL url = new URL(str_url);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");

            con.setConnectTimeout(10000);
            con.setReadTimeout(10000);

            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeUTF(ParameterStringBuilder.getParamsString(parameters));
            out.flush();
            out.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            return content.toString();

        } catch (IOException me) {
            me.printStackTrace();
        } finally {
            if(con != null) {
                con.disconnect();
            }
        }

        return "io_exception_sent";
    }
}
