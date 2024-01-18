package com.infile.api.structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ResponseCatalog {

    public static String getResponse(int code) {
        Map<Integer, String> response = new HashMap<>();

        response.put(1000, "Message 1000: OK");

        //Session errors
        response.put(1001, "Message 1001: User doesn't exist");
        response.put(1002, "Message 1002: User was deleted");
        response.put(1003, "Message 1003: Password is incorrect");

        //Token errors
        response.put(2001, "Message 2001: Token is expired");

        //Generic error
        response.put(5000, "Message 5000: Is Empty");
        response.put(5001, "Message 5001: An error has ocurred");

        return response.get(code);
    }

}
