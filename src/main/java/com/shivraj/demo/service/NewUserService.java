package com.shivraj.demo.service;

import com.shivraj.demo.payload.Users.getAllUsers.AllUserData;
import com.shivraj.demo.payload.Users.getAllUsers.AllUserResponce;
import com.shivraj.demo.payload.Users.getSectionByUser.UserWiseSection;

import java.io.IOException;

public interface NewUserService {

    public UserWiseSection GetSectionByUser(String token , String Userid) throws IOException;

    public AllUserData getAllUsers(String token) throws IOException;
//
//    public AllUserData getSectionByUserWithPagination(String token, Integer limit, String role, String starting_after, String ending_before, String count) throws IOException;


    public AllUserData getSectionByUserWithPagination(String token, Integer limit) throws IOException;
}
