package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.payload.school.getUsersBySchool.GetUsersBySchool;
import com.shivraj.demo.payload.sections.getAllSection.AllSection;
import com.shivraj.demo.payload.sections.getCourseForSection.GetCourseForSection;
import com.shivraj.demo.payload.sections.getDistrictForSection.GetDistrictForSection;
import com.shivraj.demo.payload.sections.getSchoolForSection.GetSchoolForSection;
import com.shivraj.demo.payload.sections.getSectionById.GetSectionById;
import com.shivraj.demo.payload.sections.getTermsForSection.GetTermsForSection;
import com.shivraj.demo.payload.sections.getUsersForSections.GetUsersForSections;
import com.shivraj.demo.response.ResponseHandler;
import com.shivraj.demo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/clever")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    //Returns the sections for a course
    @GetMapping("/GetAllSections")
    public ResponseEntity<Object> getAllSection(@RequestHeader(AppConstants.HEADER_STRING) String token ,
                                                @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit,
                                                @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {
        AllSection allSection = sectionService.getAllSection(token , limit , starting_after);

        if(allSection.getData().size() == 0){
            return ResponseHandler.responseBuilder(allSection,"Section Not Found", 0);
        }
        else {
            return ResponseHandler.responseBuilder(allSection , "Sections Fetched Successfully",1);
        }
    }

    //Returns a specific section
    @GetMapping("/sections/{id}")
    public ResponseEntity<Object> getSectionById(@RequestHeader(AppConstants.HEADER_STRING) String token ,@PathVariable String id) throws IOException {

        GetSectionById getSectionById = sectionService.getSectionById(token,id);

        if(getSectionById.getData().getId().isEmpty()){
            return ResponseHandler.responseBuilder(getSectionById , "Section Not Found For Id", 0);
        }else {
            return ResponseHandler.responseBuilder(getSectionById , "Sections For Id Fetched Successfully",1);
        }
    }

    //Returns a specific section
    @GetMapping("sections/{id}/course")
    public ResponseEntity<Object> getCourseBySectionId(@RequestHeader(AppConstants.HEADER_STRING) String token ,@PathVariable String id) throws IOException {

        GetCourseForSection getCourseForSection = sectionService.getCourseForSection(token , id);

        if(getCourseForSection.getData().getId().isEmpty()){
            return ResponseHandler.responseBuilder(getCourseForSection , "Courses Not Found For Section Id", 0);
        }else {
            return ResponseHandler.responseBuilder(getCourseForSection , "Courses For Sections Id Fetched Successfully",1);
        }
    }

    //Returns the district for a section
    @GetMapping("sections/{id}/district")
    public ResponseEntity<Object> getDistrictForSection(@RequestHeader(AppConstants.HEADER_STRING) String token ,@PathVariable String id) throws IOException {

        GetDistrictForSection getDistrictForSection = sectionService.getDistrictForSection(token , id);

        if(getDistrictForSection.getData().getId().isEmpty()){
            return ResponseHandler.responseBuilder(getDistrictForSection , "District Not Found For Section Id", 0);
        }else {
            return ResponseHandler.responseBuilder(getDistrictForSection , "District For Sections Id Fetched Successfully",1);
        }
    }


    //Returns the school for a section
    @GetMapping("sections/{id}/school")
    public ResponseEntity<Object> getSchoolForSection(@RequestHeader(AppConstants.HEADER_STRING) String token ,@PathVariable String id) throws IOException {

        GetSchoolForSection getSchoolForSection = sectionService.getSchoolForSection(token,id);
        if(getSchoolForSection.getData().getId().isEmpty()){
            return ResponseHandler.responseBuilder(getSchoolForSection , "School Not Found For Section Id", 0);
        }else {
            return ResponseHandler.responseBuilder(getSchoolForSection , "School For Sections Id Fetched Successfully",1);
        }
    }


    //Returns the term for a section
    @GetMapping("sections/{id}/term")
    public ResponseEntity<Object> getTermsForSection(@RequestHeader(AppConstants.HEADER_STRING) String token ,@PathVariable String id) throws IOException {

        GetTermsForSection getTermsForSection = sectionService.getTermsForSection(token,id);

        if(getTermsForSection.getData().getId().isEmpty()){
            return ResponseHandler.responseBuilder(getTermsForSection , "Terms Not Found For Section Id", 0);
        }else {
            return ResponseHandler.responseBuilder(getTermsForSection , "Terms For Sections Id Fetched Successfully",1);
        }
    }


    //Returns the student and/or teacher users for a section
    @GetMapping("sections/{id}/users")
    public ResponseEntity<Object> getUsersForSections(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id ,
                                                     @RequestParam(value = "role", defaultValue = "null") String role,
                                                     @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit,
                                                     @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {

        GetUsersForSections getUsersForSections = sectionService.getUsersForSections(token,id,role,limit,starting_after);
        if(getUsersForSections.getData().size() == 0){
            return ResponseHandler.responseBuilder(getUsersForSections ,"Users Not Found For Section",0);
        }else {
            return ResponseHandler.responseBuilder(getUsersForSections,"Users Fetched Successfully !!!",1);
        }
    }
}
