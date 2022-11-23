package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.entity.Token;
import com.shivraj.demo.payload.meApi.MeResponce;
import com.shivraj.demo.service.AuthService;
import com.shivraj.demo.service.CleverService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;


import java.io.IOException;

@RestController
@RequestMapping("/Clever")
public class CleverController {



    @Autowired
    private CleverService cleverService;

    @Autowired
    private AuthService authService;


    @PostMapping("/getToken")
    public String getToken(@RequestBody String Url) throws IOException, ParseException {

        String s = cleverService.getAccessToken(Url);

        return s;
    }

    @PostMapping("/getAccessToken")
    public Token getAccessToken(@RequestBody String url) throws IOException, ParseException {

        Token token = authService.getAccessToken(url);
        return token;
    }

    @GetMapping("/meInfo")
    public MeResponce getMeInfo(@RequestHeader(AppConstants.HEADER_STRING) String token) throws IOException {

        MeResponce meResponce = authService.GetMeInfo(token);


        return meResponce;
    }




}
