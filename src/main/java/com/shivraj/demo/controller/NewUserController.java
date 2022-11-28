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
import com.shivraj.demo.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/Clever")
public class NewUserController {

    @Autowired
    private NewUserService newUserService;

    @GetMapping("/users/{id}/sections")
    public ResponseEntity<UserWiseSection>  getSectionByUser(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id) throws IOException {

        System.out.println("User token:-"+token);
        System.out.println("Id:-"+id);

        UserWiseSection userWiseSection = newUserService.GetSectionByUser(token,id);


        return new ResponseEntity<UserWiseSection>(userWiseSection, HttpStatus.OK) ;
    }

    @GetMapping("/allusers")
    public ResponseEntity<AllUserData> getSectionByUser(@RequestHeader(AppConstants.HEADER_STRING) String token) throws IOException {

        System.out.println("harsh"+token);

        AllUserData allUsers = newUserService.getAllUsers(token);


        return new ResponseEntity<AllUserData>(allUsers, HttpStatus.OK) ;
    }

//    @GetMapping("/allusersWithFilter")
//    public ResponseEntity<AllUserData>  getSectionByUserWithPagination(@RequestHeader(AppConstants.HEADER_STRING) String token , @RequestParam(value = "school_name", defaultValue = "") String schoolName,
//                                                               @RequestParam(value = "limit", defaultValue = "1") Integer limit,
//                                                               @RequestParam(value = "role", defaultValue = "contact") String role,
//                                                               @RequestParam(value = "starting_after", defaultValue = "6324f28bd19bb414ab822add") String starting_after,
//                                                               @RequestParam(value = "ending_before", defaultValue = "6324f28bd19bb414ab822ad1") String ending_before, @RequestParam(value = "count", defaultValue = "false") String count) throws IOException {
//
//        AllUserData allUsers = newUserService.getSectionByUserWithPagination(token,limit,role,starting_after,ending_before,count);
//
//
//        return new ResponseEntity<AllUserData>(allUsers, HttpStatus.OK) ;
//    }

    @GetMapping("/allusersWithFilter")
    public ResponseEntity<AllUserData>  getSectionByUserWithPagination(@RequestHeader(AppConstants.HEADER_STRING) String token, @RequestParam(value = "limit", defaultValue = "5") Integer limit) throws IOException {

        AllUserData allUsers = newUserService.getSectionByUserWithPagination(token,limit);


        return new ResponseEntity<AllUserData>(allUsers, HttpStatus.OK) ;
    }


    @GetMapping("users/{id}/district")
    public ResponseEntity<GetDistrictForUser> getDistrictForUser(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id) throws IOException {
        GetDistrictForUser getDistrictForUser = newUserService.getDistrictForUser(token,id);

        return new ResponseEntity<GetDistrictForUser>(getDistrictForUser,HttpStatus.OK);

    }

    @GetMapping("users/{id}/mycontacts")
    public ResponseEntity<GetContactUserForStudent> getContactUserForStudent(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id) throws IOException {
        GetContactUserForStudent getContactUserForStudent = newUserService.getContactUserForStudent(token,id);
        return new ResponseEntity<GetContactUserForStudent>(getContactUserForStudent,HttpStatus.OK);
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
