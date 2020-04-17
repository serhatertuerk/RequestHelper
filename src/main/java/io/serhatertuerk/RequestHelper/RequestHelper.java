package io.serhatertuerk.RequestHelper;

import java.util.Map;

public class RequestHelper extends PostHttpRequest {

    /**
     * Removes redundancy as sending the request and formatting the result
     * @param parameters The parameters to send the request with
     * @return result of the server without the small space at the beginning (\uFEFF)
     */
    public static String send_request(String url, Map<String, String> parameters) {
        String result = post_http_request_with_args(url, parameters);

        result = StringHelper.delete_first_empty_space(result);

        return result;
    }
}
