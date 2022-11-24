package com.shivraj.demo.service;

import com.shivraj.demo.payload.getAllUsers.AllUserData;
import com.shivraj.demo.payload.getSectionByUser.UserWiseSection;

import java.io.IOException;

public interface NewUserService {

    public UserWiseSection GetSectionByUser(String token , String Userid) throws IOException;

    public AllUserData getAllUsers(String token) throws IOException;
}
