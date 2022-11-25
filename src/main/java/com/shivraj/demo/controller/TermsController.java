package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.payload.terms.getAllTerms.AllTerms;
import com.shivraj.demo.service.TermsService;
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
public class TermsController {

    @Autowired
    private TermsService termsService;

    @GetMapping("/getAllTerms")
    public ResponseEntity<AllTerms> getAllTerms(@RequestHeader(AppConstants.HEADER_STRING) String token) throws IOException {
        AllTerms terms = termsService.getAllTerms(token);
        return new ResponseEntity<AllTerms>(terms,HttpStatus.OK);
    }
}
