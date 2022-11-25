package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.payload.school.getAllSchool.AllSchool;
import com.shivraj.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/Clever")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/getAllSchool")
    public ResponseEntity<AllSchool> GetAllSchool(@RequestHeader(AppConstants.HEADER_STRING) String token) throws IOException {

        System.out.println("token :-"+token);

        AllSchool allSchool = schoolService.getAllSchool(token);

        return new ResponseEntity<AllSchool>(allSchool , HttpStatus.OK);
    }

}
