package com.shivraj.demo.service;

import com.shivraj.demo.payload.school.getAllSchool.AllSchool;

import java.io.IOException;

public interface SchoolService {

    public AllSchool getAllSchool(String token) throws IOException;
}
