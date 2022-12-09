package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.entity.Clever;
import com.shivraj.demo.entity.Token;
import com.shivraj.demo.payload.Users.getUserById.GetUserById;
import com.shivraj.demo.payload.auth.meinfo.MeInfo;
import com.shivraj.demo.service.AuthService;
import com.shivraj.demo.service.CleverService;
import com.shivraj.demo.service.NewUserService;
import com.squareup.okhttp.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CleverServiceImpl implements CleverService {

    @Autowired
    private AuthService authService;

    @Autowired
    private NewUserService userService;


    String access_token = null;
    Response response = null;


    @Override
    public GetUserById getAccessToken(String url) throws IOException, ParseException {


        Token token = authService.getAccessToken(AppConstants.AUTH_TOKEN,url);

        access_token = token.getAccessToken();

        MeInfo meInfo = GetMeInfo(token);

        GetUserById getUserById = userService.getUserById("Bearer "+token.getAccessToken(),meInfo.getData().getId());
      return getUserById;
    }

    public String getApiCall(String url , String token) throws IOException {


        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", token)
                .build();

       Response response = client.newCall(request).execute();

        return response.body().string();
    }

    public String postApiCall(RequestBody body , String url , String token) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Basic "+token)
                .addHeader("content-type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();

    }

    public String getUserInfo(String info) throws ParseException, IOException {

            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(info);
            String type = (String) jsonObject.get("type");


            JSONObject data = (JSONObject) jsonObject.get("data");

            String id = (String) data.get("id");
            String district = (String) data.get("district");

            String url = "https://api.clever.com/v3.0/users/"+id;
            String token = "Bearer "+access_token;

            String apiResponse = getApiCall(url,token);

        return apiResponse;

    }

    public MeInfo GetMeInfo(Token token) throws ParseException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/me")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer "+token.getAccessToken())
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Invalid Auth Token Or Enter Active Redirect Url !!!");

        return objectMapper.readValue(response.body().string() , MeInfo.class);

    }


    public String PostToken(String Url , String Code , String GrantType) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Clever c = new Clever();
        c.setCode(Code);
        c.setGrant_type(GrantType);
        c.setRedirect_uri(Url);

        String CleverAsJson = objectMapper.writeValueAsString(c);


        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, CleverAsJson);

        Request request = new Request.Builder()
                .url("https://clever.com/oauth/tokens")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Basic "+AppConstants.AUTH_TOKEN)
                .addHeader("content-type", "application/json")
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "Check URl & token");

        return response.body().string();
    }


    public static List<String> extractUrls(String text)
    {
        List<String> containedUrls = new ArrayList<String>();
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find())
        {
            containedUrls.add(text.substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }
        return containedUrls;
    }
}
