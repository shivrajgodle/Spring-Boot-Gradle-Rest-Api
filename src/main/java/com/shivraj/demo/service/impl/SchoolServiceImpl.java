package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.exception.ResourceNotFoundException;
import com.shivraj.demo.payload.school.getAllSchool.AllSchool;
import com.shivraj.demo.payload.school.getCoursesForSchool.GetCoursesForSchool;
import com.shivraj.demo.payload.school.getDistrictForSchool.GetDistrictForSchool;
import com.shivraj.demo.payload.school.getSchoolById.GetSchoolById;
import com.shivraj.demo.payload.school.getSchoolByUser.GetSchoolByUser;
import com.shivraj.demo.payload.school.getSectionForSchool.GetSectionForSchool;
import com.shivraj.demo.payload.school.getTermsForSchool.GetTermsForSchool;
import com.shivraj.demo.payload.school.getUsersBySchool.GetUsersBySchool;
import com.shivraj.demo.service.AuthService;
import com.shivraj.demo.service.SchoolService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthService authService;

    @Override
    public AllSchool getAllSchool(String token, Integer limit , String starting_after) throws IOException {

        authService.isValidAccessToken(token);

        String start = "null";
        String ApiUrl = null;

        if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/schools?limit="+limit;
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/schools?limit="+limit+"&starting_after="+starting_after;
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(ApiUrl)
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

    @Override
    public GetUsersBySchool getUserBySchoolId(String token, String id , String role, String primary, Integer limit, String starting_after) throws IOException {

        authService.isValidAccessToken(token);

        String start = "null";
        String prime = "null";
        String ApiUrl = null;

        if(starting_after.equals(start) && primary.equals(prime)){
            ApiUrl = "https://api.clever.com/v3.0/schools/"+id+"/users?role="+role+"&limit="+limit;
        }
        else if(primary.equals(prime)){
            ApiUrl = "https://api.clever.com/v3.0/schools/"+id+"/users?role="+role+"&limit="+limit+"&starting_after="+starting_after+"";
        }
        else if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/schools/"+id+"/users?role="+role+"&primary="+primary+"&limit="+limit+"";
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/schools/"+id+"/users?role="+role+"&primary="+primary+"&limit="+limit+"&starting_after="+starting_after+"";
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

        return objectMapper.readValue(responseBody.string() , GetUsersBySchool.class);

    }

    @Override
    public GetCoursesForSchool getCoursesForSchool(String token, String id , Integer limit, String starting_after) throws IOException {


        authService.isValidAccessToken(token);

        String start = "null";
        String ApiUrl = null;

        if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/schools/"+id+"/courses?limit="+limit;
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/schools/"+id+"/courses?limit="+limit+"&starting_after="+starting_after;
        }

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND ,"Course Info Not Found With School ID");

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetCoursesForSchool.class);

    }

    @Override
    public GetDistrictForSchool getDistrictForSchool(String token, String id) throws IOException {

        authService.isValidAccessToken(token);
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/schools/"+id+"/district")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"District Info Not Found With School ID"+id);

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetDistrictForSchool.class);
    }

    @Override
    public GetSectionForSchool getSectionForSchool(String token, String id, Integer limit, String starting_after) throws IOException {

        authService.isValidAccessToken(token);

        String start = "null";
        String ApiUrl = null;

        if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/schools/"+id+"/sections?limit="+limit;
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/schools/"+id+"/sections?limit="+limit+"&starting_after="+starting_after;
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
        return objectMapper.readValue(responseBody.string() , GetSectionForSchool.class);
    }

    @Override
    public GetTermsForSchool getTermsForSchool(String token, String id, Integer limit, String starting_after) throws IOException {

        authService.isValidAccessToken(token);

        String start = "null";
        String ApiUrl = null;

        if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/schools/"+id+"/terms?limit="+limit;
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/schools/"+id+"/terms?limit="+limit+"&starting_after="+starting_after;
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
        return objectMapper.readValue(responseBody.string() , GetTermsForSchool.class);
    }

//
//    @Override
//    public FinalSchool getAllSchoolForDistrict(AllSchool allSchool) {
//
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
//        GetAllSchoolForDistrict getAllSchoolForDistrict  = modelMapper.map(allSchool , GetAllSchoolForDistrict.class);
//
//        Data data = new Data();
//        data.setDistrict_Id(getAllSchoolForDistrict.getData().get(0).getData().getDistrict());
//
//        NewSchool newSchool = new NewSchool();
//        newSchool.setSchool(getAllSchoolForDistrict.getData());
//
//        FinalSchool finalSchool = new FinalSchool();
//        finalSchool.setData(newSchool);
//        finalSchool.setMessage("All Schools for District fetched Successfully");
//        finalSchool.setStatus(1);
//        return finalSchool;
//    }


    @Override
    public GetSchoolById getSchoolById(String token, String id) throws IOException {

        System.out.println("token:-"+token);
        System.out.println("id:-"+id);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/schools/"+id)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResourceNotFoundException("All School Info","User Id", id);

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetSchoolById.class);
    }


}
