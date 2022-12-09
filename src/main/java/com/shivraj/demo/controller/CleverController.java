package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.entity.Token;
import com.shivraj.demo.payload.Users.getUserById.GetUserById;
import com.shivraj.demo.payload.auth.meinfo.MeInfo;
import com.shivraj.demo.payload.meApi.MeResponce;
import com.shivraj.demo.response.ResponseHandler;
import com.shivraj.demo.service.AuthService;
import com.shivraj.demo.service.CleverService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;


import java.io.IOException;

@RestController
@RequestMapping("/clever")
public class CleverController {



    @Autowired
    private CleverService cleverService;

    @Autowired
    private AuthService authService;


    //This Api Will Take Url as Input and Give User info as Output
    @PostMapping("/GetToken")
    public ResponseEntity<Object> getToken(@RequestBody String Url) throws IOException, ParseException {

        GetUserById getUserById = cleverService.getAccessToken(Url);

        if (getUserById.getData().getId().isEmpty()){
            return ResponseHandler.responseBuilder(getUserById,"UserInfo Not Found",0);
        }
        else {
            return ResponseHandler.responseBuilder(getUserById,"UserInfo fetched Successfully !!!",1);
        }

    }


    //This Api will return Access token for Redirect URl generated from Clever
    @PostMapping("/GetAccessToken")
    public ResponseEntity<Object> getAccessToken(@RequestHeader(AppConstants.HEADER_STRING) String token ,@RequestBody String url) throws IOException {

        Token gotToken = authService.getAccessToken(token , url);

        if (gotToken.getAccessToken().isEmpty()){
            return ResponseHandler.responseBuilder(gotToken,"Access token Not Found",0);
        }
        else {
            return ResponseHandler.responseBuilder(gotToken,"Access token Info fetched Successfully !!!",1);
        }
    }

    @GetMapping("/meInfo")
    public MeResponce getMeInfo(@RequestHeader(AppConstants.HEADER_STRING) String token) throws IOException {

        MeResponce meResponce = authService.GetMeInfo(token);
        return meResponce;
    }




}
