package com.shivraj.demo.payload.auth.responce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DistrictDTO {
    @JsonProperty("district_id")
    private String districtId;
    @JsonProperty("id")
    private String id;
    @JsonProperty("created")
    private String created;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("owner")
    private OwnerDTO owner;

    public DistrictDTO() {
        super();
    }

    public DistrictDTO(String districtId, String id, String created, String accessToken, OwnerDTO owner) {
        this.districtId = districtId;
        this.id = id;
        this.created = created;
        this.accessToken = accessToken;
        this.owner = owner;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "DistrictDTO{" +
                "districtId='" + districtId + '\'' +
                ", id='" + id + '\'' +
                ", created='" + created + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", owner=" + owner +
                '}';
    }
}
