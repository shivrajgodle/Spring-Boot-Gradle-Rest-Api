package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.exception.ResourceNotFoundException;
import com.shivraj.demo.payload.terms.getAllTerms.AllTerms;
import com.shivraj.demo.payload.terms.getDistrictForTerms.GetDistrictForTerms;
import com.shivraj.demo.payload.terms.getSchoolForTerms.GetSchoolsForTerms;
import com.shivraj.demo.payload.terms.getTermsById.GetTermsById;
import com.shivraj.demo.service.AuthService;
import com.shivraj.demo.service.TermsService;
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
public class TermsServiceImpl implements TermsService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private AuthService authService;

    @Override
    public AllTerms getAllTerms(String token , Integer limit , String starting_after) throws IOException {

        authService.isValidAccessToken(token);

        String start = "null";
        String ApiUrl = null;

        if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/terms?limit="+limit;
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/terms?limit="+limit+"&starting_after="+starting_after;
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(ApiUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Terms Info Not Found");

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , AllTerms.class);
    }

    @Override
    public GetTermsById getTermsById(String token, String id) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/terms/"+id)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Terms Info Not Found");

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetTermsById.class);
    }

    @Override
    public GetDistrictForTerms getDistrictForTerms(String token, String id) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/terms/"+id+"/district")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"District Info Not Found");

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetDistrictForTerms.class);
    }

    @Override
    public GetSchoolsForTerms getSchoolsForTerms(String token, String id , Integer limit, String starting_after) throws IOException {

        authService.isValidAccessToken(token);

        String start = "null";
        String ApiUrl = null;

        if(starting_after.equals(start)){
            ApiUrl = "https://api.clever.com/v3.0/terms/"+id+"/schools?limit="+limit;
        }
        else {
            ApiUrl = "https://api.clever.com/v3.0/terms/"+id+"/schools?limit="+limit+"&starting_after="+starting_after;
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(ApiUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"School Info Not Found");

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetSchoolsForTerms.class);
    }


}
