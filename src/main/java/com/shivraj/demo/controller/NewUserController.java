package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.payload.Users.getAllUsers.AllUserData;
import com.shivraj.demo.payload.Users.getAllUsers.AllUserResponce;
import com.shivraj.demo.payload.Users.getContactUserForStudent.GetContactUserForStudent;
import com.shivraj.demo.payload.Users.getDistrictForUser.GetDistrictForUser;
import com.shivraj.demo.payload.Users.getSchoolForUser.GetSchoolForUser;
import com.shivraj.demo.payload.Users.getSectionByUser.UserWiseSection;
import com.shivraj.demo.payload.Users.getStudentForTeacher.GetStudentsForTeacher;
import com.shivraj.demo.payload.Users.getTeacherForStudent.GetTeacherForStudent;
import com.shivraj.demo.response.ResponseHandler;
import com.shivraj.demo.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/clever")
public class NewUserController {

    @Autowired
    private NewUserService newUserService;

    //Returns the sections for a user
    @GetMapping("/users/{id}/sections")
    public ResponseEntity<Object>  getSectionByUser(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id,
                                                             @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit,
                                                             @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {

        UserWiseSection userWiseSection = newUserService.GetSectionByUser(token,id,limit,starting_after);

        if(userWiseSection.getData().size() == 0){
            return ResponseHandler.responseBuilder(userWiseSection , "Section Not found for the User !!!" , 0);
        }else {
            return ResponseHandler.responseBuilder(userWiseSection ,"Sections For User Fetched Successfully !!!",1);
        }
    }


    //Returns a list of contact, district admin, staff, student, and/or teacher users
    @GetMapping("/allUsers")
    public ResponseEntity<Object> getAllUsers(@RequestHeader(AppConstants.HEADER_STRING) String token,
                                                   @RequestParam(value = "limit", defaultValue = "2") Integer limit ,
                                                   @RequestParam(value = "role", defaultValue = "null") String role,
                                                   @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {

        AllUserData allUsers = newUserService.getAllUsers(token,limit,role,starting_after);

        if(allUsers.getData().size() == 0){
            return ResponseHandler.responseBuilder(allUsers , "Users Not Available" , 0);
        }
        else {
            return ResponseHandler.responseBuilder(allUsers,"Users fetched Successfully !!!",1);
        }

    }


    //Returns the district for a user
    @GetMapping("users/{id}/district")
    public ResponseEntity<Object> getDistrictForUser(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id) throws IOException {
        GetDistrictForUser getDistrictForUser = newUserService.getDistrictForUser(token,id);

        if(getDistrictForUser.getData().getName().isEmpty()){
            return ResponseHandler.responseBuilder(getDistrictForUser , "District Info Not Found", 0);
        }else {
            return ResponseHandler.responseBuilder(getDistrictForUser,"District Info fetched Successfully !!!",1);
        }

    }


    //Returns the contact users for a student user
    @GetMapping("users/{id}/myContacts")
    public ResponseEntity<Object> getContactUserForStudent(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id,
                                                                             @RequestParam(value = "limit", defaultValue = AppConstants.LIMIT) Integer limit,
                                                                             @RequestParam(value = "starting_after", defaultValue = "null") String starting_after) throws IOException {
        GetContactUserForStudent getContactUserForStudent = newUserService.getContactUserForStudent(token,id,limit,starting_after);

        if(getContactUserForStudent.getData().size() == 0){
            return ResponseHandler.responseBuilder(getContactUserForStudent , "My Contacts Info Not Found !!!",0);
        }else {
            return ResponseHandler.responseBuilder(getContactUserForStudent,"MyContacts Info Fetched Successfully",1);
        }
    }

    @GetMapping("users/{id}/mystudents")
    public ResponseEntity<GetStudentsForTeacher> getStudentsForTeacher(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id) throws IOException {
        GetStudentsForTeacher getStudentsForTeacher = newUserService.getStudentsForTeacher(token,id);
        return new ResponseEntity<GetStudentsForTeacher>(getStudentsForTeacher,HttpStatus.OK);
    }

    @GetMapping("users/{id}/myteachers")
    public ResponseEntity<GetTeacherForStudent> getTeacherForStudent(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id) throws IOException {

        GetTeacherForStudent getTeacherForStudent = newUserService.getTeacherForStudent(token,id);
        return new ResponseEntity<GetTeacherForStudent>(getTeacherForStudent,HttpStatus.OK);
    }

    @GetMapping("users/{id}/schools")
    public ResponseEntity<GetSchoolForUser> getSchoolForUser(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id) throws IOException {

        GetSchoolForUser getSchoolForUser = newUserService.getSchoolForUser(token,id);
        return new ResponseEntity<GetSchoolForUser>(getSchoolForUser,HttpStatus.OK);
    }

}
