package com.shivraj.demo.service;


import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface CleverService {

    public String getAccessToken(String url) throws IOException, ParseException;
}
