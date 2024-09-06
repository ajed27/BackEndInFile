package com.infile.api.structure.response;


public record ResponseMessage(int code, String message, Object data) {
    public ResponseMessage(ResponseCode responseCode, Object data){
        this(responseCode.getCode(), responseCode.getMessage(), data);
    }
}
