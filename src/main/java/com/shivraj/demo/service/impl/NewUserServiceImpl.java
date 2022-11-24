package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.exception.ResourceNotFoundException;
import com.shivraj.demo.payload.getAllUsers.AllUserData;
import com.shivraj.demo.payload.getSectionByUser.UserWiseSection;
import com.shivraj.demo.service.NewUserService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import org.springframework.stereotype.Service;

import java.io.IOException;

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

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResourceNotFoundException("Section","Userid",Userid);

        ResponseBody responseBody = client.newCall(request).execute().body();

       UserWiseSection  userWiseSection =  objectMapper.readValue(responseBody.string() , UserWiseSection.class);

        return userWiseSection;
    }

    @Override
    public AllUserData getAllUsers(String token) throws IOException {


        System.out.println("Token :-"+token);

        ObjectMapper objectMapper = new ObjectMapper();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/users")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResourceNotFoundException("All user Info","Token", AppConstants.INVALID_ACCESS_TOKEN);

        ResponseBody responseBody = client.newCall(request).execute().body();

        AllUserData  allUsers =  objectMapper.readValue(responseBody.string() , AllUserData.class);


        return allUsers;
    }
}
