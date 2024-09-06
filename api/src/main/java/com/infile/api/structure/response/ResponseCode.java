package com.infile.api.structure.response;


import lombok.Getter;

@Getter
public enum ResponseCode {

    SUCCESS(1000, "OK"),

    USER_DOESNT_EXIST(1001, "Message 1001: User doesn't exist"),

    USER_DELETED(1002, "Message 1002: User was deleted"),

    PASSWORD_INCORRECT(1003, "Message 1003: Password is incorrect"),

    DATA_NOT_FOUND(3000, "Message 3000: Data not found"),

    ERROR(5001, "Message 5001: An error has occurred"),

    UNAUTHORIZED(3005, "Message 3005: Unauthorized");

    private final int code;

    private final String message;

    ResponseCode(int code, String message){
        this.code = code;
        this.message = message;
    }

}
