package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.payload.school.getAllSchool.AllSchool;
import com.shivraj.demo.payload.school.getCoursesForSchool.GetCoursesForSchool;
import com.shivraj.demo.payload.school.getDistrictForSchool.GetDistrictForSchool;
import com.shivraj.demo.payload.school.getSchoolById.GetSchoolById;
import com.shivraj.demo.payload.school.getSectionForSchool.GetSectionForSchool;
import com.shivraj.demo.payload.school.getTermsForSchool.GetTermsForSchool;
import com.shivraj.demo.payload.school.getUsersBySchool.GetUsersBySchool;
import com.shivraj.demo.response.ResponseHandler;
import com.shivraj.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/clever")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

   //Returns a list of schools
    @GetMapping("/getAllSchool")
    public ResponseEntity<Object> GetAllSchool(@RequestHeader(AppConstants.HEADER_STRING) String token , @RequestParam(value = "limit", defaultValue = "2") Integer limit,@RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {
        AllSchool allSchool = schoolService.getAllSchool(token,limit,starting_after);

        if(allSchool.getData().size() == 0){
            return ResponseHandler.responseBuilder(allSchool,"Schools not available",0);
        }else{
            return ResponseHandler.responseBuilder(allSchool,"Schools data Fetched Successfully !!! ",1);
        }
    }


    //Returns a specific school
    @GetMapping("/schools/{id}")
    public ResponseEntity<Object> GetSchoolById(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id) throws IOException {

        GetSchoolById getSchoolById = schoolService.getSchoolById(token,id);
        if(getSchoolById.getData().getId().isEmpty()){
            return ResponseHandler.responseBuilder(getSchoolById , "Schools not found for School ID",0);
        }
        else {
            return ResponseHandler.responseBuilder(getSchoolById , "School Data fetched Successfully",1);
        }
    }

    //Returns the staff, student, and/or teacher users for a school
    @GetMapping("/schools/{id}/users")
    public ResponseEntity<Object> getUsersBySchoolId(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id ,
                                                               @RequestParam(value = "role", defaultValue = "student") String role,
                                                               @RequestParam(value = "primary", defaultValue = "null") String primary,
                                                               @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit,
                                                               @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {

        GetUsersBySchool getSchoolByUser = schoolService.getUserBySchoolId(token,id,role,primary,limit,starting_after);
        if(getSchoolByUser.getData().size() == 0){
            return ResponseHandler.responseBuilder(getSchoolByUser ,"Users Not Found For School",0);
        }else {
            return ResponseHandler.responseBuilder(getSchoolByUser,"Users Fetched Successfully !!!",1);
        }
    }

    //Returns the courses for a school
    @GetMapping("/schools/{id}/courses")
    public ResponseEntity<Object> getAllCourseForSchool(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id,
                                                                     @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit,
                                                                     @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {
        GetCoursesForSchool getCoursesForSchool = schoolService.getCoursesForSchool(token,id,limit,starting_after);

        if(getCoursesForSchool.getData().size() == 0){
            return ResponseHandler.responseBuilder(getCoursesForSchool ,"Courses Not found for School Id",0);
        }
        else {
            return ResponseHandler.responseBuilder(getCoursesForSchool , "Courses Fetched Successfully !!!",1);
        }
    }

    //Returns the district for a school
    @GetMapping("/schools/{id}/district")
    public ResponseEntity<Object> getTheDistrictForSchool(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id) throws IOException {

        GetDistrictForSchool getDistrictForSchool = schoolService.getDistrictForSchool(token,id);

        if (getDistrictForSchool.getData().getId().isEmpty()){
            return ResponseHandler.responseBuilder(getDistrictForSchool , "District Info Not Found for School",0);
        }
        else {
            return ResponseHandler.responseBuilder(getDistrictForSchool,"District Info for School Fetched Successfully !!!",1);
        }
    }

    //Returns the sections for a school
    @GetMapping("/school/{id}/sections")
    public ResponseEntity<Object> getSectionsForSchool(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id ,
                                                       @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit,
                                                       @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {

        GetSectionForSchool getSectionForSchool = schoolService.getSectionForSchool(token,id,limit,starting_after);

        if(getSectionForSchool.getData().size() == 0){
            return ResponseHandler.responseBuilder(getSectionForSchool,"Sections not found for the School",0);
        }
        else {
            return ResponseHandler.responseBuilder(getSectionForSchool,"Sections for the School Fetched Successfully !!!",1);
        }
    }

    //Returns the terms for a school
    @GetMapping("/schools/{id}/terms")
   public ResponseEntity<Object> getTermForSchool(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id ,
                                                             @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit,
                                                             @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {
       GetTermsForSchool getTermsForSchool = schoolService.getTermsForSchool(token,id,limit,starting_after);
       if(getTermsForSchool.getData().size() == 0){
           return ResponseHandler.responseBuilder(getTermsForSchool,"Terms Not Found for School",0);
       }else {
           return ResponseHandler.responseBuilder(getTermsForSchool,"Terms For School Fetched Successful",1);
       }
   }


}
