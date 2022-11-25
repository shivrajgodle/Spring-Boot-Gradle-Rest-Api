package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.exception.ResourceNotFoundException;
import com.shivraj.demo.payload.Users.getAllUsers.AllUserData;
import com.shivraj.demo.payload.school.getAllSchool.AllSchool;
import com.shivraj.demo.service.SchoolService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Override
    public AllSchool getAllSchool(String token) throws IOException {

        System.out.println("Token :-"+token);

        ObjectMapper objectMapper = new ObjectMapper();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/schools")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResourceNotFoundException("All user Info","Token", AppConstants.INVALID_ACCESS_TOKEN);

        ResponseBody responseBody = client.newCall(request).execute().body();

        AllSchool allSchool =  objectMapper.readValue(responseBody.string() , AllSchool.class);
        return allSchool;
    }
}
