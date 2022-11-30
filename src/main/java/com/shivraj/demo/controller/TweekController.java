package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.payload.auth.GetAccessToken;
import com.shivraj.demo.payload.auth.responce.*;
import com.shivraj.demo.service.AuthService;
import com.shivraj.demo.service.DistrictService;
import com.shivraj.demo.service.NewUserService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/Clever")
public class TweekController {

    @Autowired
    private NewUserService userService;

    @Autowired
    private AuthService authService;

    @Autowired
    private DistrictService districtService;


    // 1. Use tokens API to verify whether entered district ID is a valid Clever District ID or not
    @GetMapping("/District/{id}")
    public ResponseEntity<NewValidDistrictIdResponse> verifyDistrictId(@RequestHeader(AppConstants.HEADER_STRING) String token, @PathVariable String id) throws IOException, ParseException {

        GetAccessToken getToken = authService.getNewAccessToken(token);

        NewValidDistrictIdResponse newValidDistrictIdResponse = districtService.CheckValidDistrictId(id,getToken);

        return new ResponseEntity<NewValidDistrictIdResponse>(newValidDistrictIdResponse, HttpStatus.OK);
    }




}
