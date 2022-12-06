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
import com.shivraj.demo.service.AuthService;
import com.shivraj.demo.service.NewUserService;
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
public class NewUserServiceImpl implements NewUserService {


    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private AuthService authService;

    @Override
    public UserWiseSection GetSectionByUser(String token, String Userid , Integer limit , String starting_after) throws IOException {

        authService.isValidAccessToken(token);

        String start = "null";
        String ApiUrl = null;

        if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/users/"+Userid+"/sections?limit="+limit;
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/users/"+Userid+"/sections?limit="+limit+"&starting_after="+starting_after;
        }

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();
        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Section not found for id"+Userid);

        ResponseBody responseBody = client.newCall(request).execute().body();
        return objectMapper.readValue(responseBody.string() , UserWiseSection.class);
    }


    @Override
    public AllUserData getAllUsers(String token, Integer limit , String role, String starting_after) throws IOException {

        authService.isValidAccessToken(token);

        String start = "null";
        String roles = "null";
        String ApiUrl = null;

        if(starting_after.equals(start) && role.equals(roles)){
            ApiUrl = "https://api.clever.com/v3.0/users?limit="+limit;
        }
        else if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/users?limit="+limit+"&role="+role+"";
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/users?limit="+limit+"&role="+role+"&starting_after="+starting_after+"";
        }

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

          Response response = client.newCall(request).execute();
          if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND ,"Userinfo Not found");
        ResponseBody responseBody = client.newCall(request).execute().body();

        return  objectMapper.readValue(responseBody.string() , AllUserData.class);

    }

    @Override
    public GetDistrictForUser getDistrictForUser(String token, String Userid) throws IOException {

        authService.isValidAccessToken(token);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/users/"+Userid+"/district")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Incorrect UserId :-"+ Userid);

        ResponseBody responseBody = client.newCall(request).execute().body();

        GetDistrictForUser getDistrictForUser =  objectMapper.readValue(responseBody.string() , GetDistrictForUser.class);

        return getDistrictForUser;
    }


    @Override
    public GetContactUserForStudent getContactUserForStudent(String token, String Userid , Integer limit , String starting_after) throws IOException {

        authService.isValidAccessToken(token);

        String start = "null";
        String ApiUrl = null;


        if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/users/"+Userid+"/mycontacts?limit="+limit;
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/users/"+Userid+"/mycontacts?limit="+limit+"&starting_after="+starting_after;
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(ApiUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Contact info Not Found for UserId:-"+Userid);

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetContactUserForStudent.class);

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
