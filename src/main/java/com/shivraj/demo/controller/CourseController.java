package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.payload.courses.getAllCourses.AllCourses;
import com.shivraj.demo.payload.courses.getCoursesForId.GetCoursesForId;
import com.shivraj.demo.payload.courses.getDistrictForCourses.GetDistrictForCourse;
import com.shivraj.demo.payload.courses.getSchoolsForCourses.GetSchoolsForCourses;
import com.shivraj.demo.response.ResponseHandler;
import com.shivraj.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/clever")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //Returns a list of courses
    @GetMapping("/getAllCourses")
    public ResponseEntity<Object> getAllCourses(@RequestHeader(AppConstants.HEADER_STRING) String Token,
                                                    @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit,
                                                    @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {
        AllCourses allCourses = courseService.getAllCourses(Token,limit,starting_after);
        if(allCourses.getData().size() == 0){
           return ResponseHandler.responseBuilder(allCourses,"Courses Not Found",0);
        }else {
            return ResponseHandler.responseBuilder(allCourses,"Courses Fetched Successfully !!!",1);
        }
    }

    //Returns a specific course
    @GetMapping("/courses/{id}")
    public ResponseEntity<Object> getCourseForId(@RequestHeader(AppConstants.HEADER_STRING) String token,@PathVariable String id) throws IOException {

        GetCoursesForId getCoursesForId = courseService.getCoursesForId(token,id);
        if(getCoursesForId.getData().getId().isEmpty()){
            return ResponseHandler.responseBuilder(getCoursesForId,"Course Not Found",0);
        }else {
            return ResponseHandler.responseBuilder(getCoursesForId,"Course fetched Successfully !!!",1);
        }
    }

    //Returns the district for a course
    @GetMapping("/courses/{id}/district")
    public ResponseEntity<Object> getDistrictForCourse(@RequestHeader(AppConstants.HEADER_STRING) String token,@PathVariable String id) throws IOException {
        GetDistrictForCourse getDistrictForCourse = courseService.getDistrictForCourse(token,id);
        if(getDistrictForCourse.getData().getId().isEmpty()){
            return ResponseHandler.responseBuilder(getDistrictForCourse , "District Not Found",0);
        }else {
            return ResponseHandler.responseBuilder(getDistrictForCourse,"District info for Course fetched Successfully !!!",1);
        }
    }

    @GetMapping("/courses/{id}/schools")
    public ResponseEntity<Object> getSchoolsForCourses(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id ,
                                                       @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit,
                                                       @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {

        GetSchoolsForCourses getSchoolsForCourses = courseService.getSchoolsForCourse(token,id,limit,starting_after);

        if(getSchoolsForCourses.getData().size() == 0){
            return ResponseHandler.responseBuilder(getSchoolsForCourses , "Schools Not Found For Course ID",0);
        }else {
            return ResponseHandler.responseBuilder(getSchoolsForCourses , "Schools for Course Id Fetched Successfully !!!",1);
        }
    }



}
