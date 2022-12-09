package com.shivraj.demo.service;

import com.shivraj.demo.entity.Token;
import com.shivraj.demo.payload.auth.GetAccessToken;
import com.shivraj.demo.payload.meApi.MeResponce;
import org.json.simple.parser.ParseException;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

public interface AuthService {

    public boolean isValidAccessToken(String token) throws ResponseStatusException, IOException;

    public boolean isValidAuthToken(String token) throws ResponseStatusException, IOException;

    public Token getAccessToken(String token ,String url) throws IOException;

    public MeResponce GetMeInfo(String token) throws IOException;

    public GetAccessToken getNewAccessToken(String token) throws IOException, ParseException;


}
