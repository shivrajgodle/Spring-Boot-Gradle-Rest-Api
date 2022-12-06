package com.shivraj.demo.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> responseBuilder(Object responseObject ,String message , Integer status){

        Map<String ,Object> response = new HashMap<>();
        response.put("data" ,responseObject);
        response.put("message" , message);
        response.put("status",status);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
