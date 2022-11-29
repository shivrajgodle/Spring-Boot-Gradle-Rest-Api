package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.payload.district.getAllDistrict.GetAllDistrict;
import com.shivraj.demo.payload.district.getDistrictById.GetDistrictById;
import com.shivraj.demo.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/Clever")
public class DistrictController {

    @Autowired
    private DistrictService districtService;


    @GetMapping("/getAllDistrict")
    public ResponseEntity<GetAllDistrict> getAllDistrict(@RequestHeader(AppConstants.HEADER_STRING) String token) throws IOException {
        GetAllDistrict getAllDistrict = districtService.getAllDistrict(token);
        return new ResponseEntity<GetAllDistrict>(getAllDistrict, HttpStatus.OK);
    }

    @GetMapping("/districts/{id}")
    public ResponseEntity<GetDistrictById> getDistrictById(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id) throws IOException {

        GetDistrictById getDistrictById = districtService.getDistrictById(token,id);
        return new ResponseEntity<GetDistrictById>(getDistrictById,HttpStatus.OK);
    }
}
