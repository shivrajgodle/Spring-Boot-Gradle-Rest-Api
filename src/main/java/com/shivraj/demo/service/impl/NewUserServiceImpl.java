package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.exception.ResourceNotFoundException;
import com.shivraj.demo.payload.Users.getAllUsers.AllUserData;
import com.shivraj.demo.payload.Users.getAllUsers.AllUserResponce;
import com.shivraj.demo.payload.Users.getContactUserForStudent.GetContactUserForStudent;
import com.shivraj.demo.payload.Users.getDistrictForUser.GetDistrictForUser;
import com.shivraj.demo.payload.Users.getSchoolForUser.GetSchoolForUser;
import com.shivraj.demo.payload.Users.getSectionByUser.UserWiseSection;
import com.shivraj.demo.payload.Users.getStudentForTeacher.GetStudentsForTeacher;
import com.shivraj.demo.payload.Users.getTeacherForStudent.GetTeacherForStudent;
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

          Response response = client.newCall(request).execute();

          if(!response.isSuccessful()) throw new ResourceNotFoundException("All user Info","Token", AppConstants.INVALID_ACCESS_TOKEN);

        ResponseBody responseBody = client.newCall(request).execute().body();

        AllUserData  allUsers =  objectMapper.readValue(responseBody.string() , AllUserData.class);

        return allUsers;
    }

    @Override
    public GetDistrictForUser getDistrictForUser(String token, String Userid) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/users/"+Userid+"/district")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResourceNotFoundException("District Info","UserId", Userid);

        ResponseBody responseBody = client.newCall(request).execute().body();

        GetDistrictForUser getDistrictForUser =  objectMapper.readValue(responseBody.string() , GetDistrictForUser.class);

        return getDistrictForUser;
    }

    @Override
    public GetContactUserForStudent getContactUserForStudent(String token, String Userid) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/users/"+Userid+"/mycontacts")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResourceNotFoundException("Contact User Info","UserId", Userid);

        ResponseBody responseBody = client.newCall(request).execute().body();

        GetContactUserForStudent getContactUserForStudent =  objectMapper.readValue(responseBody.string() , GetContactUserForStudent.class);

        return getContactUserForStudent;
    }

    @Override
    public GetStudentsForTeacher getStudentsForTeacher(String token, String Userid) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/users/"+Userid+"/mystudents")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResourceNotFoundException("Student Info","UserId", Userid);

        ResponseBody responseBody = client.newCall(request).execute().body();

        GetStudentsForTeacher getStudentsForTeacher =  objectMapper.readValue(responseBody.string() , GetStudentsForTeacher.class);

        return getStudentsForTeacher;
    }

    @Override
    public GetTeacherForStudent getTeacherForStudent(String token, String Userid) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/users/"+Userid+"/myteachers")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();
        if(!response.isSuccessful()) throw new ResourceNotFoundException("Teacher Info","UserId", Userid);

        ResponseBody responseBody = client.newCall(request).execute().body();

        GetTeacherForStudent getTeacherForStudent =  objectMapper.readValue(responseBody.string() , GetTeacherForStudent.class);

        return getTeacherForStudent;
    }

    @Override
    public GetSchoolForUser getSchoolForUser(String token, String Userid) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/users/"+Userid+"/schools")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();
        if(!response.isSuccessful()) throw new ResourceNotFoundException("School Info","UserId", Userid);

        ResponseBody responseBody = client.newCall(request).execute().body();

        GetSchoolForUser getSchoolForUser =  objectMapper.readValue(responseBody.string() , GetSchoolForUser.class);

        return getSchoolForUser;
    }

}
