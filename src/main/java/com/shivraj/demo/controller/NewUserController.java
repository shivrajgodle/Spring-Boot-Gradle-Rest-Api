package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.payload.getSectionByUser.UserWiseSection;
import com.shivraj.demo.payload.getSectionByUser.UserWiseSectionResponse;
import com.shivraj.demo.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/Clever")
public class NewUserController {

    @Autowired
    private NewUserService newUserService;

    @GetMapping("/users/{id}/sections")
    public ResponseEntity<UserWiseSection>  getSectionByUser(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id) throws IOException {

        System.out.println("User token:-"+token);
        System.out.println("Id:-"+id);

        UserWiseSection userWiseSection = newUserService.GetSectionByUser(token,id);

        return new ResponseEntity<UserWiseSection>(userWiseSection, HttpStatus.OK) ;
    }

}
