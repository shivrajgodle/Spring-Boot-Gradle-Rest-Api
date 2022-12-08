package com.shivraj.demo.service;

import com.shivraj.demo.payload.sections.getAllSection.AllSection;
import com.shivraj.demo.payload.sections.getCourseForSection.GetCourseForSection;
import com.shivraj.demo.payload.sections.getDistrictForSection.GetDistrictForSection;
import com.shivraj.demo.payload.sections.getSchoolForSection.GetSchoolForSection;
import com.shivraj.demo.payload.sections.getSectionById.GetSectionById;
import com.shivraj.demo.payload.sections.getTermsForSection.GetTermsForSection;
import com.shivraj.demo.payload.sections.getUsersForSections.GetUsersForSections;

import java.io.IOException;

public interface SectionService {
    public AllSection getAllSection(String token ,Integer limit , String starting_after) throws IOException;

    public GetSectionById getSectionById(String token , String id) throws IOException;

    public GetCourseForSection getCourseForSection(String token , String id) throws IOException;

    public GetDistrictForSection getDistrictForSection(String token , String id) throws IOException;

    public GetSchoolForSection getSchoolForSection(String token , String id) throws IOException;

    public GetTermsForSection getTermsForSection(String token , String id) throws IOException;

    public GetUsersForSections getUsersForSections(String token ,String id , String role, Integer limit, String starting_after) throws IOException;

}
