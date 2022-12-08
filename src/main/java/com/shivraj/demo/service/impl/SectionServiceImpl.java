package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.exception.ResourceNotFoundException;
import com.shivraj.demo.payload.courses.getAllCourses.AllCourses;
import com.shivraj.demo.payload.school.getUsersBySchool.GetUsersBySchool;
import com.shivraj.demo.payload.sections.getAllSection.AllSection;
import com.shivraj.demo.payload.sections.getCourseForSection.GetCourseForSection;
import com.shivraj.demo.payload.sections.getDistrictForSection.GetDistrictForSection;
import com.shivraj.demo.payload.sections.getSchoolForSection.GetSchoolForSection;
import com.shivraj.demo.payload.sections.getSectionById.GetSectionById;
import com.shivraj.demo.payload.sections.getTermsForSection.GetTermsForSection;
import com.shivraj.demo.payload.sections.getUsersForSections.GetUsersForSections;
import com.shivraj.demo.service.AuthService;
import com.shivraj.demo.service.SectionService;
import com.squareup.okhttp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private AuthService authService;

    @Override
    public AllSection getAllSection(String token , Integer limit , String starting_after) throws IOException {

        authService.isValidAccessToken(token);

        String start = "null";
        String ApiUrl = null;

        if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/sections?limit="+limit;
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/sections?limit="+limit+"&starting_after="+starting_after;
        }


        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(ApiUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Section Info not found");

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , AllSection.class);
    }

    @Override
    public GetSectionById getSectionById(String token, String id) throws IOException {

        authService.isValidAccessToken(token);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/sections/"+id)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Section Info not found for Id");

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetSectionById.class);
    }

    @Override
    public GetCourseForSection getCourseForSection(String token, String id) throws IOException {
        authService.isValidAccessToken(token);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/sections/"+id+"/course")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Course Info not found for Id");

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetCourseForSection.class);
    }

    @Override
    public GetDistrictForSection getDistrictForSection(String token, String id) throws IOException {

        authService.isValidAccessToken(token);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/sections/"+id+"/district")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND , "District Info not found for Id");

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetDistrictForSection.class);

    }

    @Override
    public GetSchoolForSection getSchoolForSection(String token, String id) throws IOException {

        authService.isValidAccessToken(token);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/sections/"+id+"/school")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND , "District Info not found for Id");

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetSchoolForSection.class);
    }

    @Override
    public GetTermsForSection getTermsForSection(String token, String id) throws IOException {

        authService.isValidAccessToken(token);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/sections/"+id+"/term")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Terms Info not found for Id");

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetTermsForSection.class);
    }

    @Override
    public GetUsersForSections getUsersForSections(String token, String id, String role, Integer limit, String starting_after) throws IOException {

        authService.isValidAccessToken(token);

        String start = "null";
        String roles = "null";
        String ApiUrl = null;

        if(starting_after.equals(start) && role.equals(roles)){
            ApiUrl = "https://api.clever.com/v3.0/sections/"+id+"/users?limit="+limit;
        }
        else if(role.equals(roles)){
            ApiUrl = "https://api.clever.com/v3.0/sections/"+id+"/users?limit="+limit+"&starting_after="+starting_after+"";
        }
        else if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/sections/"+id+"/users?role="+role+"&limit="+limit+"";
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/sections/"+id+"/users?role="+role+"&limit="+limit+"&starting_after="+starting_after+"";
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(ApiUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found for Section Id"+id);

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetUsersForSections.class);
    }
}
