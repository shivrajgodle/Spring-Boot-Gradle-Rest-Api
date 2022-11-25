package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.exception.ResourceNotFoundException;
import com.shivraj.demo.payload.Users.getAllUsers.AllUserData;
import com.shivraj.demo.payload.Users.getAllUsers.AllUserResponce;
import com.shivraj.demo.payload.Users.getSectionByUser.UserWiseSection;
import com.shivraj.demo.service.NewUserService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class NewUserServiceImpl implements NewUserService {


    @Autowired
    ObjectMapper objectMapper;

    @Override
    public UserWiseSection GetSectionByUser(String token, String Userid) throws IOException {

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

//    @Override
//    public AllUserData getSectionByUserWithPagination(String token, Integer limit, String role, String starting_after, String ending_before, String count) throws IOException {
//
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://api.clever.com/v3.0/users?limit="+limit+"&role="+role+"&starting_after="+starting_after+"&ending_before="+ending_before+"&count="+count+"")
//                .get()
//                .addHeader("accept", "application/json")
//                .addHeader("authorization", token)
//                .build();
//
//      //  Response response = client.newCall(request).execute();
//
//      //  if(!response.isSuccessful()) throw new ResourceNotFoundException("All user Info","Token", AppConstants.INVALID_ACCESS_TOKEN);
//
//        ResponseBody responseBody = client.newCall(request).execute().body();
//
//        AllUserData  allUsers =  objectMapper.readValue(responseBody.string() , AllUserData.class);
//
//        return allUsers;
//    }

    @Override
    public AllUserData getSectionByUserWithPagination(String token, Integer limit) throws IOException {

        OkHttpClient client = new OkHttpClient();

        String NewLimit = "?limit="+limit;

        String NewUrl = "https://api.clever.com/v3.0/users"+NewLimit;

        System.out.println("new url :-"+NewUrl);

        Request request = new Request.Builder()
                .url(NewUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        //  Response response = client.newCall(request).execute();

        //  if(!response.isSuccessful()) throw new ResourceNotFoundException("All user Info","Token", AppConstants.INVALID_ACCESS_TOKEN);

        ResponseBody responseBody = client.newCall(request).execute().body();

        AllUserData  allUsers =  objectMapper.readValue(responseBody.string() , AllUserData.class);

        return allUsers;
    }

}
