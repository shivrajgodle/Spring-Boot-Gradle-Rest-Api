package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.payload.terms.getAllTerms.AllTerms;
import com.shivraj.demo.payload.terms.getDistrictForTerms.GetDistrictForTerms;
import com.shivraj.demo.payload.terms.getSchoolForTerms.GetSchoolsForTerms;
import com.shivraj.demo.payload.terms.getTermsById.GetTermsById;
import com.shivraj.demo.response.ResponseHandler;
import com.shivraj.demo.service.TermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/clever")
public class TermsController {

    @Autowired
    private TermsService termsService;


    //Returns a list of terms
    @GetMapping("/GetAllTerms")
    public ResponseEntity<Object> getAllTerms(@RequestHeader(AppConstants.HEADER_STRING) String token ,
                                              @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit,
                                              @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {
        AllTerms terms = termsService.getAllTerms(token , limit , starting_after);
        if(terms.getData().size() == 0){
            return ResponseHandler.responseBuilder(terms,"Terms Info Not Found",0);
        }else {
            return ResponseHandler.responseBuilder(terms,"Terms Info Fetched Successfully !!!",1);
        }
    }

    //Returns a specific term
    @GetMapping("/terms/{id}")
    public ResponseEntity<Object> getTermsById(@RequestHeader(AppConstants.HEADER_STRING)  String token , @PathVariable String id) throws IOException {

        GetTermsById allTerms = termsService.getTermsById(token,id);
        if(allTerms.getData().getId().isEmpty()){
            return ResponseHandler.responseBuilder(allTerms,"Terms Info Not Found",0);
        }else {
            return ResponseHandler.responseBuilder(allTerms,"Terms Info Fetched Successfully !!!",1);
        }
    }


    //Returns the district for a term
    @GetMapping("terms/{id}/district")
    public ResponseEntity<Object> getDistrictForTerms(@RequestHeader(AppConstants.HEADER_STRING)  String token , @PathVariable String id) throws IOException {

        GetDistrictForTerms getDistrictForTerms = termsService.getDistrictForTerms(token,id);
        if(getDistrictForTerms.getData().getId().isEmpty()){
            return ResponseHandler.responseBuilder(getDistrictForTerms,"District Info Not Found",0);
        }else {
            return ResponseHandler.responseBuilder(getDistrictForTerms,"District Info Fetched Successfully !!!",1);
        }
    }


    //Returns the schools for a term
    @GetMapping("/terms/{id}/schools")
    public ResponseEntity<Object> getSchoolsForTerms(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id ,
                                              @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit,
                                              @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {
        GetSchoolsForTerms getSchoolsForTerms = termsService.getSchoolsForTerms(token , id , limit , starting_after);
        if(getSchoolsForTerms.getData().size() == 0){
            return ResponseHandler.responseBuilder(getSchoolsForTerms,"School Info Not Found",0);
        }else {
            return ResponseHandler.responseBuilder(getSchoolsForTerms,"School Info Fetched Successfully !!!",1);
        }
    }

}
