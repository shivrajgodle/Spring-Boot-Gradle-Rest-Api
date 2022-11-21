package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.entity.Clever;
import com.shivraj.demo.service.CleverService;
import com.squareup.okhttp.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CleverServiceImpl implements CleverService {

    String access_token = null;
    Response response = null;

    @Override
    public String getAccessToken(String url) throws IOException, ParseException {

        String token = null;
        String RedirectLink = extractUrls(url).toString();
        String NewUrl = RedirectLink.substring(1,50);
        String Code = RedirectLink.substring(56,76);

        try{
            token = PostToken(NewUrl , Code , AppConstants.GRANT_TYPE);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        String finalInfo = GetMeInfo(token);
        System.out.println("Me Info"+finalInfo);

      String info = getUserInfo(finalInfo);

//        JSONParser jsonParser = new JSONParser();
//
//        JSONObject jsonObject = (JSONObject) jsonParser.parse(info);
//
//        JSONObject data = (JSONObject) jsonObject.get("data");
//        JSONObject name = (JSONObject) data.get("name");
//
//        String fname = (String) name.get("name");

        return info;
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


            System.out.println("Type is :-"+type);
            System.out.println("Id is :-"+id);
            System.out.println("access_token:-"+this.access_token);

            String url = "https://api.clever.com/v3.0/users/"+id;
            String token = "Bearer "+access_token;

            System.out.println("guru"+token);

            String apiResponse = getApiCall(url,token);

        return apiResponse;

    }

    public String GetMeInfo(String token) throws ParseException, IOException {

        JSONParser jsonParser = new JSONParser();

      JSONObject jsonObject = (JSONObject) jsonParser.parse(token);
      access_token = (String) jsonObject.get("access_token");
      String token_type = (String) jsonObject.get("token_type");

        System.out.println("access_token"+access_token);
        System.out.println("token_type"+token_type);

        String url = "https://api.clever.com/v3.0/me";
        String ctoken = "Bearer "+access_token;

        String apiResponse = getApiCall(url,ctoken);

        return apiResponse;
    }


    public String PostToken(String Url , String Code , String GrantType) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Clever c = new Clever();
        c.setCode(Code);
        c.setGrant_type(GrantType);
        c.setRedirect_uri(Url);

        String CleverAsJson = objectMapper.writeValueAsString(c);
        System.out.println("body: "+CleverAsJson);

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
