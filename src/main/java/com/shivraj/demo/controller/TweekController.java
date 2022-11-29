package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.payload.Users.getSchoolForUser.GetSchoolForUser;
import com.shivraj.demo.payload.auth.GetAccessToken;
import com.shivraj.demo.payload.tweek.AllStudentDTO;
import com.shivraj.demo.payload.tweek.NewDataDTO;
import com.shivraj.demo.service.AuthService;
import com.shivraj.demo.service.NewUserService;
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


    @GetMapping("/District/{id}")
    public ResponseEntity<GetAccessToken> verifyDistrictId(@RequestHeader(AppConstants.HEADER_STRING) String token, @PathVariable String id) throws IOException {

        GetAccessToken getToken = authService.getNewAccessToken(token);

        System.out.println("Id is:-"+id);

        if(id == getToken.)

        return new ResponseEntity<GetAccessToken>(getToken, HttpStatus.OK);
    }



}
