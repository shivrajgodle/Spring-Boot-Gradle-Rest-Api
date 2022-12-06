package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.entity.Page;
import com.shivraj.demo.payload.auth.GetAccessToken;
import com.shivraj.demo.payload.auth.responce.*;
import com.shivraj.demo.payload.school.getAllSchool.AllSchool;
import com.shivraj.demo.payload.school.getSectionForSchool.GetSectionForSchool;
import com.shivraj.demo.payload.school.getUsersBySchool.GetUsersBySchool;
import com.shivraj.demo.response.ResponseHandler;
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
public class IntegrationController {

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


//    2. Use  /schools  API to get schools of a particular district by using a district access_token
    @GetMapping("/district/allSchools")
    public ResponseEntity<Object> GetAllSchoolForPerticularDistrictToken(@RequestHeader(AppConstants.HEADER_STRING) String token, @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit, @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {

        AllSchool allSchool = schoolService.getAllSchool(token, limit,starting_after);

        if(allSchool.getData().size() == 0){
            return ResponseHandler.responseBuilder(allSchool,"Schools not found !!!",0);
        }
        else {
            return ResponseHandler.responseBuilder(allSchool,"Fetched Requested Schools for the District Successfully",1);
        }
    }


//    3. Fetch students of a particular school using  /schools/{id}/users  API with role = "student" request parameter
    @GetMapping("/schools/{id}/students")
    public ResponseEntity<Object> getStudentsForSchool(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id ,
                                                       @RequestParam(value = "role", defaultValue = "student") String role,
                                                       @RequestParam(value = "primary", defaultValue = "null") String primary,
                                                       @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit,
                                                       @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {

        GetUsersBySchool getUsersBySchool = schoolService.getUserBySchoolId(token,id,role,primary,limit,starting_after);
        if(getUsersBySchool.getData().size() == 0){
            return ResponseHandler.responseBuilder(getUsersBySchool ,"Students not found !!!",0);
        }
        else {
            return ResponseHandler.responseBuilder(getUsersBySchool ,"Fetched Requested students for the School Successfully",1);
        }
    }

//    4. Fetch teachers of a particular school using  /schools/{id}/users  API with role = "teacher" request parameter
    @GetMapping("/schools/{id}/teachers")
    public ResponseEntity<Object> getTeachersForSchool(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id ,
                                                       @RequestParam(value = "role", defaultValue = "teacher") String role,
                                                       @RequestParam(value = "primary", defaultValue = "null") String primary,
                                                       @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit,
                                                       @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {


        GetUsersBySchool getUsersBySchool = schoolService.getUserBySchoolId(token,id,role,primary,limit,starting_after);
        if(getUsersBySchool.getData().size() == 0){
            return ResponseHandler.responseBuilder(getUsersBySchool ,"Teachers not found !!!",0);
        }
        else {
            return ResponseHandler.responseBuilder(getUsersBySchool ,"Fetched Requested Teachers for the School Successfully !!!",1);
        }
    }

//    5. Fetch sections of a particular school using  /schools/{id}/sections  API

    @GetMapping("/schools/{id}/sections")
    public ResponseEntity<Object> getSectionsForSchool(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id ,
                                                       @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit,
                                                       @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {

        GetSectionForSchool getSectionForSchool = schoolService.getSectionForSchool(token,id,limit,starting_after);

        if(getSectionForSchool.getData().size() == 0){
            return ResponseHandler.responseBuilder(getSectionForSchool,"Sections not found !!!",0);
        }
        else {
            return ResponseHandler.responseBuilder(getSectionForSchool,"Fetched Requested Sections for the School Successfully !!!",1);
        }
    }



//    public void GetId(FinalSchool finalSchool,String token) throws IOException {
//        String id = null;
//        for (int i = 0; i < finalSchool.getData().getSchool().size(); i++) {
//            id = finalSchool.getData().getSchool().get(i).getData().getId();
//        }
//        System.out.println("id is:-"+id);
//       // GetAllSchoolForPerticularDistrictToken(token, Integer.valueOf(AppConstants.LIMIT),id);
//    }




//    @GetMapping("/check")
//    public String checkException(){
//
//        String id = "23sdfdf33322";
//
//        if(10/5 == 2){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//                    "id not found:-"+id);
//        }
//
//        return "hello";
//    }



}
