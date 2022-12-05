package com.shivraj.demo.service;

import com.shivraj.demo.payload.school.getAllSchool.AllSchool;
import com.shivraj.demo.payload.school.getCoursesForSchool.GetCoursesForSchool;
import com.shivraj.demo.payload.school.getDistrictForSchool.GetDistrictForSchool;
import com.shivraj.demo.payload.school.getSchoolById.GetSchoolById;
import com.shivraj.demo.payload.school.getSchoolByUser.GetSchoolByUser;
import com.shivraj.demo.payload.tweek.getAllSchoolForDistrict.GetAllSchoolForDistrict;
import com.shivraj.demo.payload.tweek.getAllSchoolForDistrict.response.FinalSchool;

import java.io.IOException;

public interface SchoolService {

    public AllSchool getAllSchool(String token , Integer limit , String starting_after) throws IOException;

    public GetSchoolById getSchoolById(String token , String id) throws IOException;

    public GetSchoolByUser getSchoolByUser(String token , String id) throws IOException;

    public GetCoursesForSchool getCoursesForSchool(String token , String id) throws IOException;

    public GetDistrictForSchool getDistrictForSchool(String token , String id) throws IOException;

    public FinalSchool getAllSchoolForDistrict(AllSchool allSchool);

}
