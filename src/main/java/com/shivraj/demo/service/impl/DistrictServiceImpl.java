package com.shivraj.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivraj.demo.config.AppConstants;
import com.shivraj.demo.exception.ResourceNotFoundException;
import com.shivraj.demo.payload.auth.GetAccessToken;
import com.shivraj.demo.payload.auth.responce.DataDTO;
import com.shivraj.demo.payload.auth.responce.DistrictDTO;
import com.shivraj.demo.payload.auth.responce.NewValidDistrictIdResponse;
import com.shivraj.demo.payload.auth.responce.OwnerDTO;
import com.shivraj.demo.payload.courses.getAllCourses.AllCourses;
import com.shivraj.demo.payload.district.getAllDistrict.GetAllDistrict;
import com.shivraj.demo.payload.district.getDistrictById.GetDistrictById;
import com.shivraj.demo.service.DistrictService;
import com.squareup.okhttp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DistrictServiceImpl implements DistrictService {


    @Autowired
    ObjectMapper objectMapper;

    @Override
    public GetAllDistrict getAllDistrict(String token) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/districts")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();

        if(!response.isSuccessful()) throw new ResourceNotFoundException("District Info","Token:-", AppConstants.INVALID_ACCESS_TOKEN);

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetAllDistrict.class);

    }

    @Override
    public GetDistrictById getDistrictById(String token, String id) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.clever.com/v3.0/districts/"+id)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("authorization", token)
                .build();

        Response response = client.newCall(request).execute();
        if(!response.isSuccessful()) throw new ResourceNotFoundException("District Info","District ID:-", id);

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string() , GetDistrictById.class);
    }


//    Method for validating proper district id
    @Override
    public NewValidDistrictIdResponse CheckValidDistrictId(String id , GetAccessToken getToken) {


        NewValidDistrictIdResponse newValidDistrictIdResponse = new NewValidDistrictIdResponse();
        DataDTO dataDTO = new DataDTO();
        DistrictDTO districtDTO = new DistrictDTO();
        OwnerDTO ownerDTO = new OwnerDTO();

        ownerDTO.setId(getToken.getData().get(0).getOwner().id());
        ownerDTO.setType(getToken.getData().get(0).getOwner().getType());

        districtDTO.setDistrictId(id);
        districtDTO.setCreated(getToken.getData().get(0).getCreated());
        districtDTO.setOwner(ownerDTO);
        districtDTO.setAccessToken(getToken.getData().get(0).getAccessToken());
        districtDTO.setId(getToken.getData().get(0).getId());

        dataDTO.setDistrict(districtDTO);

        if (id.equals(getToken.getData().get(0).getOwner().id())) {
            newValidDistrictIdResponse.setMessage("District Id has been validated Successfully !!!");
            newValidDistrictIdResponse.setStatus(1);
            newValidDistrictIdResponse.setData(dataDTO);
        }
        else{
            newValidDistrictIdResponse.setMessage("Please Provide Correct District ID");
            newValidDistrictIdResponse.setStatus(0);
            newValidDistrictIdResponse.setData(null);
        }
        return newValidDistrictIdResponse;
    }
}
