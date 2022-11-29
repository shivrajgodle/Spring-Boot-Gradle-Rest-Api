package com.shivraj.demo.service;

import com.shivraj.demo.payload.school.getAllSchool.AllSchool;
import com.shivraj.demo.payload.school.getCoursesForSchool.GetCoursesForSchool;
import com.shivraj.demo.payload.school.getDistrictForSchool.GetDistrictForSchool;
import com.shivraj.demo.payload.school.getSchoolById.GetSchoolById;
import com.shivraj.demo.payload.school.getSchoolByUser.GetSchoolByUser;

import java.io.IOException;

public interface SchoolService {

    public AllSchool getAllSchool(String token) throws IOException;

    public GetSchoolById getSchoolById(String token , String id) throws IOException;

    public GetSchoolByUser getSchoolByUser(String token , String id) throws IOException;

    public GetCoursesForSchool getCoursesForSchool(String token , String id) throws IOException;

    public GetDistrictForSchool getDistrictForSchool(String token , String id) throws IOException;
}
