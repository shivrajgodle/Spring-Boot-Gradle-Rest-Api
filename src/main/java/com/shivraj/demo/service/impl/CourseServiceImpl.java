package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.exception.ResourceNotFoundException;
import com.shivraj.demo.payload.courses.getAllCourses.AllCourses;
import com.shivraj.demo.payload.school.getAllSchool.AllSchool;
import com.shivraj.demo.service.CourseService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    ObjectMapper objectMapper;




    @Override
    public AllCourses getAllCourses(String Token) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/courses")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", Token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResourceNotFoundException("All School Info","Access_Token", AppConstants.INVALID_ACCESS_TOKEN);

        ResponseBody responseBody = client.newCall(request).execute().body();

        AllCourses allCourses = objectMapper.readValue(responseBody.string() , AllCourses.class);

        return allCourses;
    }
}
