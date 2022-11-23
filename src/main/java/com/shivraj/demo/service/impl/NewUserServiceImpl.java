package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.payload.getSectionByUser.UserWiseSection;
import com.shivraj.demo.payload.getSectionByUser.UserWiseSectionResponse;
import com.shivraj.demo.payload.meApi.MeResponce;
import com.shivraj.demo.service.NewUserService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class NewUserServiceImpl implements NewUserService {


    @Override
    public UserWiseSection GetSectionByUser(String token, String Userid) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/users/"+Userid+"/sections")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        ResponseBody responseBody = client.newCall(request).execute().body();

       // System.out.println("responce body wise section"+responseBody.string());

       UserWiseSection  userWiseSection =  objectMapper.readValue(responseBody.string() , UserWiseSection.class);
        return userWiseSection;
    }
}
