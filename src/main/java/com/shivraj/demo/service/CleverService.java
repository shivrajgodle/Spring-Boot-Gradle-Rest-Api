package com.shivraj.demo.service;


import com.shivraj.demo.payload.Users.getUserById.GetUserById;
import com.shivraj.demo.payload.auth.meinfo.MeInfo;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface CleverService {

    public GetUserById getAccessToken(String url) throws IOException, ParseException;
}
