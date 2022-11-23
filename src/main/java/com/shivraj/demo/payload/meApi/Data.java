package com.shivraj.demo.payload.meApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private String id;
    private String district;
    private String type;
    private String authorized_by;

    public Data() {
        super();
    }

    public Data(String id, String district, String type, String authorized_by) {
        this.id = id;
        this.district = district;
        this.type = type;
        this.authorized_by = authorized_by;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthorized_by() {
        return authorized_by;
    }

    public void setAuthorized_by(String authorized_by) {
        this.authorized_by = authorized_by;
    }
}
