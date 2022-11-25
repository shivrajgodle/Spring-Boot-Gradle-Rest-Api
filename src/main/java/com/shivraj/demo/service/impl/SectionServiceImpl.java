package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.exception.ResourceNotFoundException;
import com.shivraj.demo.payload.courses.getAllCourses.AllCourses;
import com.shivraj.demo.payload.sections.getAllSection.AllSection;
import com.shivraj.demo.service.SectionService;
import com.squareup.okhttp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public AllSection getAllSection(String token) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/sections")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", "Bearer TEST_TOKEN")
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) throw new ResourceNotFoundException("Section Info","Access_Token", AppConstants.INVALID_ACCESS_TOKEN);

        ResponseBody responseBody = client.newCall(request).execute().body();

        AllSection allSection = objectMapper.readValue(responseBody.string() , AllSection.class);

        return allSection;
    }
}
