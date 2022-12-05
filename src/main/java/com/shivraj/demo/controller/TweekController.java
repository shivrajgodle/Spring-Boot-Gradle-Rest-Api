package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.entity.Page;
import com.shivraj.demo.payload.auth.GetAccessToken;
import com.shivraj.demo.payload.auth.responce.*;
import com.shivraj.demo.payload.school.getAllSchool.AllSchool;
import com.shivraj.demo.payload.tweek.getAllSchoolForDistrict.*;
import com.shivraj.demo.payload.tweek.getAllSchoolForDistrict.response.Data;
import com.shivraj.demo.payload.tweek.getAllSchoolForDistrict.response.FinalSchool;
import com.shivraj.demo.payload.tweek.getAllSchoolForDistrict.response.NewSchool;
import com.shivraj.demo.service.AuthService;
import com.shivraj.demo.service.DistrictService;
import com.shivraj.demo.service.NewUserService;
import com.shivraj.demo.service.SchoolService;
import org.json.simple.parser.ParseException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
@RequestMapping("/clever")
public class TweekController {

    @Autowired
    private NewUserService userService;

    @Autowired
    private AuthService authService;
    @Autowired
    private DistrictService districtService;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SchoolService schoolService;


    // 1. Use tokens API to verify whether entered district ID is a valid Clever District ID or not
    @GetMapping("/district/{id}")
    public ResponseEntity<NewValidDistrictIdResponse> verifyDistrictId(@RequestHeader(AppConstants.HEADER_STRING) String token, @PathVariable String id) throws IOException, ParseException {
        authService.isValidAuthToken(token);
        GetAccessToken getToken = authService.getNewAccessToken(token);
        NewValidDistrictIdResponse newValidDistrictIdResponse = districtService.CheckValidDistrictId(id, getToken);
        return new ResponseEntity<NewValidDistrictIdResponse>(newValidDistrictIdResponse, HttpStatus.OK);
    }


    @GetMapping("/district/allSchools")
    public ResponseEntity<FinalSchool> GetAllSchoolForPerticularDistrictToken(@RequestHeader(AppConstants.HEADER_STRING) String token, @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit, @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {
        authService.isValidAccessToken(token);

        AllSchool allSchool = schoolService.getAllSchool(token, limit,starting_after);
        FinalSchool finalSchool = schoolService.getAllSchoolForDistrict(allSchool);
        return new ResponseEntity<FinalSchool>(finalSchool, HttpStatus.OK);
    }



//    public void GetId(FinalSchool finalSchool,String token) throws IOException {
//        String id = null;
//        for (int i = 0; i < finalSchool.getData().getSchool().size(); i++) {
//            id = finalSchool.getData().getSchool().get(i).getData().getId();
//        }
//        System.out.println("id is:-"+id);
//       // GetAllSchoolForPerticularDistrictToken(token, Integer.valueOf(AppConstants.LIMIT),id);
//    }




    @GetMapping("/check")
    public String checkException(){

        String id = "23sdfdf33322";

        if(10/5 == 2){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "id not found:-"+id);
        }

        return "hello";
    }



}
