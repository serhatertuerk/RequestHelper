package io.serhatertuerk.RequestHelper;

public class StringHelper {

    /**
     * The results of servers often have a small space at the beginning (\uFEFF). That should be removed.
     * @param result The result sent back by the server
     * @return result of the server without the small space at the beginning (\uFEFF)
     */
    protected static String delete_first_empty_space(String result) {
        return result
                .replaceAll("\\uFEFF", "")
                .replaceAll("\\xEF", "")
                .replaceAll("\\xBF", "")
                .replaceAll("\\xBB", "");
    }
}
