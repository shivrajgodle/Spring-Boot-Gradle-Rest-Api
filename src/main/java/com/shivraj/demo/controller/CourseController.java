package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.payload.courses.getAllCourses.AllCourses;
import com.shivraj.demo.service.CourseService;
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
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getAllCourses")
    public ResponseEntity<AllCourses> GetAllCourses(@RequestHeader(AppConstants.HEADER_STRING) String Token) throws IOException {
        AllCourses allCourses = courseService.getAllCourses(Token);
        return new ResponseEntity<AllCourses>(allCourses, HttpStatus.OK);
    }
}
