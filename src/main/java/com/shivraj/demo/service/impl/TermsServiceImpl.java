package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.exception.ResourceNotFoundException;
import com.shivraj.demo.payload.terms.AllTerms;
import com.shivraj.demo.service.TermsService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class TermsServiceImpl implements TermsService {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public AllTerms getAllTerms(String token) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/terms")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) throw new ResourceNotFoundException("Terms Info","Access_Token", AppConstants.INVALID_ACCESS_TOKEN);

        ResponseBody responseBody = client.newCall(request).execute().body();

        AllTerms allTerms = objectMapper.readValue(responseBody.string() , AllTerms.class);

        return allTerms;
    }
}
