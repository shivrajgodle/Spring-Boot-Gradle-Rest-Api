package com.shivraj.demo.service;

import com.shivraj.demo.payload.auth.GetAccessToken;
import com.shivraj.demo.payload.auth.responce.NewValidDistrictIdResponse;
import com.shivraj.demo.payload.district.getAllDistrict.GetAllDistrict;
import com.shivraj.demo.payload.district.getDistrictById.GetDistrictById;

import java.io.IOException;

public interface DistrictService {

    public GetAllDistrict getAllDistrict(String token) throws IOException;

    public GetDistrictById getDistrictById(String token , String id) throws IOException;

    public NewValidDistrictIdResponse CheckValidDistrictId(String id ,GetAccessToken getToken);
}
