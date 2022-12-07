package com.shivraj.demo.service;

import com.shivraj.demo.payload.Users.getAllUsers.AllUserData;
import com.shivraj.demo.payload.Users.getAllUsers.AllUserResponce;
import com.shivraj.demo.payload.Users.getContactUserForStudent.GetContactUserForStudent;
import com.shivraj.demo.payload.Users.getDistrictForUser.GetDistrictForUser;
import com.shivraj.demo.payload.Users.getSchoolForUser.GetSchoolForUser;
import com.shivraj.demo.payload.Users.getSectionByUser.UserWiseSection;
import com.shivraj.demo.payload.Users.getStudentForTeacher.GetStudentsForTeacher;
import com.shivraj.demo.payload.Users.getTeacherForStudent.GetTeacherForStudent;

import java.io.IOException;

public interface NewUserService {

    public UserWiseSection GetSectionByUser(String token , String Userid , Integer limit , String Starting_after) throws IOException;

    public AllUserData getAllUsers(String token, Integer limit ,String role, String starting_after) throws IOException;

    public GetDistrictForUser getDistrictForUser(String token,String Userid) throws IOException;

    public GetContactUserForStudent getContactUserForStudent(String token, String Userid , Integer limit , String starting_after) throws IOException;

    public GetStudentsForTeacher getStudentsForTeacher(String token, String Userid ,Integer limit,String starting_after) throws IOException;

    public GetTeacherForStudent getTeacherForStudent(String token, String Userid,Integer limit,String starting_after) throws IOException;

    public GetSchoolForUser getSchoolForUser(String token , String Userid , String primary,Integer limit,String starting_after) throws IOException;
}
