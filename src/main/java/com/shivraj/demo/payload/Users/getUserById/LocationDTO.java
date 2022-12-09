package com.shivraj.demo.payload.Users.getUserById;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDTO {

    @JsonProperty("address")
    private String address;
    @JsonProperty("city")
    private String city;
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lon")
    private String lon;
    @JsonProperty("state")
    private String state;
    @JsonProperty("zip")
    private String zip;

    public LocationDTO(String address, String city, String lat, String lon, String state, String zip) {
        this.address = address;
        this.city = city;
        this.lat = lat;
        this.lon = lon;
        this.state = state;
        this.zip = zip;
    }
}
