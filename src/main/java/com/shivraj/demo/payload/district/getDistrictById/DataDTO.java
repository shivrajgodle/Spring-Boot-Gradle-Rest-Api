package com.shivraj.demo.payload.district.getDistrictById;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDTO {

    @JsonProperty("login_methods")
    private List<String> loginMethods;
    @JsonProperty("error")
    private String error;
    @JsonProperty("last_sync")
    private String lastSync;
    @JsonProperty("district_contact")
    private DistrictContactDTO districtContact;
    @JsonProperty("portal_url")
    private String portalUrl;
    @JsonProperty("state")
    private String state;
    @JsonProperty("launch_date")
    private String launchDate;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sis_type")
    private String sisType;
    @JsonProperty("id")
    private String id;

    public List<String> getLoginMethods() {
        return loginMethods;
    }

    public void setLoginMethods(List<String> loginMethods) {
        this.loginMethods = loginMethods;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getLastSync() {
        return lastSync;
    }

    public void setLastSync(String lastSync) {
        this.lastSync = lastSync;
    }

    public DistrictContactDTO getDistrictContact() {
        return districtContact;
    }

    public void setDistrictContact(DistrictContactDTO districtContact) {
        this.districtContact = districtContact;
    }

    public String getPortalUrl() {
        return portalUrl;
    }

    public void setPortalUrl(String portalUrl) {
        this.portalUrl = portalUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSisType() {
        return sisType;
    }

    public void setSisType(String sisType) {
        this.sisType = sisType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
