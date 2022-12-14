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
import com.shivraj.demo.payload.Users.getUserById.GetUserById;
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
    public GetStudentsForTeacher getStudentsForTeacher(String token, String Userid,Integer limit,String starting_after) throws IOException {

        authService.isValidAccessToken(token);

        String start = "null";
        String ApiUrl = null;

        if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/users/"+Userid+"/mystudents?limit="+limit;
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/users/"+Userid+"/mystudents?limit="+limit+"&starting_after="+starting_after;
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(ApiUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student Info Not found for Teacher or Contact ID:-"+Userid);
        ResponseBody responseBody = client.newCall(request).execute().body();
        return  objectMapper.readValue(responseBody.string() , GetStudentsForTeacher.class);
    }

    @Override
    public GetTeacherForStudent getTeacherForStudent(String token, String Userid ,Integer limit,String starting_after) throws IOException {


        authService.isValidAccessToken(token);

        String start = "null";
        String ApiUrl = null;

        if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/users/"+Userid+"/myteachers?limit="+limit;
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/users/"+Userid+"/myteachers?limit="+limit+"&starting_after="+starting_after;
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(ApiUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();
        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND ,"Teacher Info Not found for Student UserId :-"+ Userid);
        ResponseBody responseBody = client.newCall(request).execute().body();
        return objectMapper.readValue(responseBody.string() , GetTeacherForStudent.class);
    }

    @Override
    public GetUserById getUserById(String token, String Userid) throws IOException {

        System.out.println("token"+token);
        System.out.println("Userid"+Userid);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/users/"+Userid)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND , "User Info Not Found For User Id");

      return objectMapper.readValue(response.body().string() , GetUserById.class);
    }

    @Override
    public GetSchoolForUser getSchoolForUser(String token, String Userid , String primary,Integer limit,String starting_after) throws IOException {


        authService.isValidAccessToken(token);

        String start = "null";
        String prime = "null";
        String ApiUrl = null;

        if(starting_after.equals(start) && primary.equals(prime)){
            ApiUrl = "https://api.clever.com/v3.0/users/"+Userid+"/schools?limit="+limit;
        }
        else if(primary.equals(prime)){
            ApiUrl = "https://api.clever.com/v3.0/users/"+Userid+"/schools?limit="+limit+"&starting_after="+starting_after+"";
        }
        else if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/users/"+Userid+"/schools?primary="+primary+"&limit="+limit+"";
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/users/"+Userid+"/schools?primary="+primary+"&limit="+limit+"&starting_after="+starting_after+"";
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(ApiUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();
        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND , "School Info Not found for UserId:-"+Userid);
        ResponseBody responseBody = client.newCall(request).execute().body();
        return objectMapper.readValue(responseBody.string() , GetSchoolForUser.class);
    }

}
