package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.payload.school.getAllSchool.AllSchool;
import com.shivraj.demo.payload.school.getCoursesForSchool.GetCoursesForSchool;
import com.shivraj.demo.payload.school.getSchoolById.GetSchoolById;
import com.shivraj.demo.payload.school.getSchoolByUser.GetSchoolByUser;
import com.shivraj.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/schools/{id}")
    public ResponseEntity<GetSchoolById> GetSchoolById(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id) throws IOException {

        GetSchoolById getSchoolById = schoolService.getSchoolById(token,id);
        return new ResponseEntity<GetSchoolById>(getSchoolById,HttpStatus.OK);
    }


    @GetMapping("/schools/{id}/users")
    public ResponseEntity<GetSchoolByUser> getSchoolById(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id) throws IOException {

        GetSchoolByUser getSchoolByUser = schoolService.getSchoolByUser(token,id);
        return new ResponseEntity<GetSchoolByUser>(getSchoolByUser,HttpStatus.OK);
    }

    @GetMapping("/schools/{id}/courses")
    public ResponseEntity<GetCoursesForSchool> getAllCourseForSchool(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id) throws IOException {

        GetCoursesForSchool getCoursesForSchool = schoolService.getCoursesForSchool(token,id);
        return new ResponseEntity<GetCoursesForSchool>(getCoursesForSchool,HttpStatus.OK);
    }

}
