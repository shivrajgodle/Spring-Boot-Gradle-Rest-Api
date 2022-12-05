package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.entity.Clever;
import com.shivraj.demo.entity.Token;
import com.shivraj.demo.exception.ResourceNotFoundException;
import com.shivraj.demo.payload.auth.GetAccessToken;
import com.shivraj.demo.payload.meApi.MeResponce;
import com.shivraj.demo.service.AuthService;
import com.squareup.okhttp.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public boolean isValidAccessToken(String token) throws ResponseStatusException, IOException {

        if (token != null && !token.contains("undefined")) {
            try {
                MeResponce meResponce = GetMeInfo(token);
                return true;
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Access token");
            }
        }
        return false;
    }

    public boolean isValidAuthToken(String token) throws ResponseStatusException, IOException {

        if (token != null && !token.contains("undefined")) {
            try {
                GetAccessToken getAccessToken = getNewAccessToken(token);
                if(getAccessToken.getData().get(0).getId() == null){
                    return false;
                }
                return true;
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Auth Token");
            }
        }
        return false;
    }


    @Override
    public Token getAccessToken(String url) throws IOException {


        String token = null;
        String RedirectLink = extractUrls(url).toString();
        String NewUrl = RedirectLink.substring(1,50);
        String Code = RedirectLink.substring(56,76);



        Clever c = new Clever();
        c.setCode(Code);
        c.setGrant_type(AppConstants.GRANT_TYPE);
        c.setRedirect_uri(NewUrl);

        String CleverAsJson = objectMapper.writeValueAsString(c);
        System.out.println("body: "+CleverAsJson);

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        com.squareup.okhttp.RequestBody body = com.squareup.okhttp.RequestBody.create(mediaType, CleverAsJson);

        Request request = new Request.Builder()
                .url("https://clever.com/oauth/tokens")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Basic "+AppConstants.AUTH_TOKEN)
                .addHeader("content-type", "application/json")
                .build();

//        Response response = client.newCall(request).execute();
//
//        if(!response.isSuccessful()) throw new TokenNotFoundException("Auth Token","Authorization Code",url);


        ResponseBody responseBody = client.newCall(request).execute().body();


        Token t = objectMapper.readValue(responseBody.string() , Token.class);

        return t;

    }


    public MeResponce GetMeInfo(String token) throws IOException {



        String url = "https://api.clever.com/v3.0/me";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResourceNotFoundException("userInfo","Token",AppConstants.INVALID_ACCESS_TOKEN);

        ResponseBody responseBody = client.newCall(request).execute().body();
        MeResponce meResponce = objectMapper.readValue(responseBody.string() , MeResponce.class);

        System.out.println("token values are"+meResponce);

        return meResponce;
    }

    @Override
    public GetAccessToken getNewAccessToken(String token) throws IOException, ParseException {


        JSONParser jsonParser = new JSONParser();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://clever.com/oauth/tokens?owner_type=district")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization",token)
                .build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        return objectMapper.readValue(responseBody.string() , GetAccessToken.class);

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
