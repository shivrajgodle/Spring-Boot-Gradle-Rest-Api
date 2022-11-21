package com.shivraj.demo.controller;

import com.shivraj.demo.entity.Clever;
import com.shivraj.demo.entity.Token;
import com.shivraj.demo.service.CleverService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@RequestMapping("/Clever")
public class CleverController {



    @Autowired
    private CleverService cleverService;

    @Autowired
    RestTemplate restTemplate;



    @PostMapping("/getToken")
    public String getToken(@RequestBody String Url) throws IOException, ParseException {

        String s = cleverService.getAccessToken(Url);

        return s;
    }

//    @PostMapping("/fetchCode")
//    public ResponseEntity<Token> fetchTokenFromCode(@RequestBody Clever clever){
//        try{
//            String url = "https://clever.com/oauth/tokens";
//
//           // ResponseEntity<String> token = restTemplate.postForEntity(url , clever , String.class).a
//
//
//
//        }catch(Exception e){
//            e.printStackTrace();
//            return new ResponseEntity("Error ! Please try with latest url code",HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<Token>();
//    }




}
