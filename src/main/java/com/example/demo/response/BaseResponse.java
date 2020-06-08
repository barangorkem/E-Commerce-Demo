package com.example.demo.response;

import lombok.Data;

@Data
public class BaseResponse {

    private String Message;

    public BaseResponse(String message) {
        Message = message;
    }
}
