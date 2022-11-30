package com.shivraj.demo.service;

import com.shivraj.demo.entity.Token;
import com.shivraj.demo.payload.auth.GetAccessToken;
import com.shivraj.demo.payload.meApi.MeResponce;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface AuthService {
    public Token getAccessToken(String url) throws IOException;

    public MeResponce GetMeInfo(String token) throws IOException;

    public GetAccessToken getNewAccessToken(String token) throws IOException, ParseException;


}
