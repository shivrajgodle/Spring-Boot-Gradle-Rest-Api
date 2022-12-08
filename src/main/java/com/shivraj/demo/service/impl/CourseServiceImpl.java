package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.exception.ResourceNotFoundException;
import com.shivraj.demo.payload.courses.getAllCourses.AllCourses;
import com.shivraj.demo.payload.courses.getCoursesForId.GetCoursesForId;
import com.shivraj.demo.payload.courses.getDistrictForCourses.GetDistrictForCourse;
import com.shivraj.demo.payload.courses.getSchoolsForCourses.GetSchoolsForCourses;
import com.shivraj.demo.payload.courses.getSectionsForCourse.GetSectionsForCourse;
import com.shivraj.demo.payload.school.getAllSchool.AllSchool;
import com.shivraj.demo.payload.school.getTermsForSchool.GetTermsForSchool;
import com.shivraj.demo.service.AuthService;
import com.shivraj.demo.service.CourseService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private AuthService authService;


    @Override
    public AllCourses getAllCourses(String token , Integer limit,String starting_after) throws IOException {

        authService.isValidAccessToken(token);

        String start = "null";
        String ApiUrl = null;

        if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/courses?limit="+limit;
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/courses?limit="+limit+"&starting_after="+starting_after;
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(ApiUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Courses Not Found");

        ResponseBody responseBody = client.newCall(request).execute().body();

       return objectMapper.readValue(responseBody.string() , AllCourses.class);
    }

    @Override
    public GetCoursesForId getCoursesForId(String token, String id) throws IOException {

        authService.isValidAccessToken(token);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/courses/"+id)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Courses Not Found For ID:-"+id);

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetCoursesForId.class);
    }

    @Override
    public GetDistrictForCourse getDistrictForCourse(String token, String id) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/courses/"+id+"/district")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND , "District Not Found For Course:-"+id);

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetDistrictForCourse.class);
    }

    @Override
    public GetSchoolsForCourses getSchoolsForCourse(String token, String id, Integer limit, String starting_after) throws IOException {

        authService.isValidAccessToken(token);

        String start = "null";
        String ApiUrl = null;

        if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/courses/"+id+"/schools?limit=1"+limit;
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/courses/"+id+"/schools?limit=1"+limit+"&starting_after="+starting_after;
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(ApiUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "School id not found:-"+id);
        ResponseBody responseBody = client.newCall(request).execute().body();
        return objectMapper.readValue(responseBody.string() , GetSchoolsForCourses.class);
    }

    @Override
    public GetSectionsForCourse getSectionsForCourse(String token, String id, Integer limit, String starting_after) throws IOException {

        authService.isValidAccessToken(token);

        String start = "null";
        String ApiUrl = null;

        if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/courses/"+id+"/sections?limit="+limit;
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/courses/"+id+"/sections?limit="+limit+"&starting_after="+starting_after;
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(ApiUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Section not found:-"+id);
        ResponseBody responseBody = client.newCall(request).execute().body();
        return objectMapper.readValue(responseBody.string() , GetSectionsForCourse.class);
    }
}
