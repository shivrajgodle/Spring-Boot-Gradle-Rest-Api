package com.shivraj.demo.service;

import com.shivraj.demo.payload.getSectionByUser.UserWiseSection;
import com.shivraj.demo.payload.getSectionByUser.UserWiseSectionResponse;

import java.io.IOException;

public interface NewUserService {

    public UserWiseSection GetSectionByUser(String token , String Userid) throws IOException;
}
