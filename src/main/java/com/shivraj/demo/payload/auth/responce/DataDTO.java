package com.shivraj.demo.payload.auth.responce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDTO {
    @JsonProperty("district")
    private DistrictDTO district;

    public DataDTO() {
        super();
    }

    public DataDTO(DistrictDTO district) {
        this.district = district;
    }

    public DistrictDTO getDistrict() {
        return district;
    }

    public void setDistrict(DistrictDTO district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "DataDTO{" +
                "district=" + district +
                '}';
    }
}
