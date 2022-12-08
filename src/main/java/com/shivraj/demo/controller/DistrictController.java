package com.shivraj.demo.controller;

import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.payload.district.getAllDistrict.GetAllDistrict;
import com.shivraj.demo.payload.district.getDistrictById.GetDistrictById;
import com.shivraj.demo.response.ResponseHandler;
import com.shivraj.demo.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/clever")
public class DistrictController {

    @Autowired
    private DistrictService districtService;


    //Returns a list of districts. In practice this will only return the one district associated with the bearer token
    @GetMapping("/GetAllDistrict")
    public ResponseEntity<Object> getAllDistrict(@RequestHeader(AppConstants.HEADER_STRING) String token) throws IOException {
        GetAllDistrict getAllDistrict = districtService.getAllDistrict(token);

        if(getAllDistrict.getData().size() == 0){
            return ResponseHandler.responseBuilder(getAllDistrict,"District Info Not Found",0);
        }else {
            return ResponseHandler.responseBuilder(getAllDistrict,"District Info Fetched Successfully !!!",1);
        }
    }

    //Returns a specific district
    @GetMapping("/districts/{id}")
    public ResponseEntity<Object> getDistrictById(@RequestHeader(AppConstants.HEADER_STRING) String token , @PathVariable String id) throws IOException {

        GetDistrictById getDistrictById = districtService.getDistrictById(token,id);
        if(getDistrictById.getData().getId().isEmpty()){
            return ResponseHandler.responseBuilder(getDistrictById , "District Info Not Found",0);
        }else {
            return ResponseHandler.responseBuilder(getDistrictById ,"District Info Fetched Successfully",1 );
        }
    }
}
