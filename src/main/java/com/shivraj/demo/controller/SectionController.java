package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.payload.sections.getAllSection.AllSection;
import com.shivraj.demo.service.SectionService;
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
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping("/getAllSections")
    public ResponseEntity<AllSection> getAllSection(@RequestHeader(AppConstants.HEADER_STRING) String token) throws IOException {
        AllSection allSection = sectionService.getAllSection(token);

        return new ResponseEntity<AllSection>(allSection, HttpStatus.OK);
    }

}
