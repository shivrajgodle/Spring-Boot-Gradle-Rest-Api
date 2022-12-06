package com.shivraj.demo.payload.school.getUsersBySchool;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDTO {

    @JsonProperty("created")
    private String created;
    @JsonProperty("district")
    private String district;
    @JsonProperty("email")
    private String email;
    @JsonProperty("last_modified")
    private String lastModified;
    @JsonProperty("name")
    private NameDTO name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("roles")
    private RolesDTO roles;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public NameDTO getName() {
        return name;
    }

    public void setName(NameDTO name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RolesDTO getRoles() {
        return roles;
    }

    public void setRoles(RolesDTO roles) {
        this.roles = roles;
    }
}
