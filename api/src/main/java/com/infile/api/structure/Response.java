package com.infile.api.structure;

import java.util.LinkedHashMap;
import java.util.Map;

public class Response {

    static int codeOk = 1000;
    static String OK = "OK";
    static String errorLabel = "error";
    static String replyLabel = "reply";
    static String statusLabel = "status";
    static String codeLabel = "code";
    static String reasonLabel = "reason";
    static String exceptionLabel = "exception";

    public static Map<String, Object> getResponse(int code, Object reply, String exception){
        String status = code == 1000 ? OK : errorLabel;
        reply = code == 1000 ? reply : "";
        String reasonError = ResponseCatalog.getResponse(code);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put(statusLabel, status);
        response.put(codeLabel, code);
        response.put(reasonLabel, reasonError);
        response.put(exceptionLabel, exception);
        response.put(replyLabel, reply);

        return response;
    }
}
