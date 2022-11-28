package com.shivraj.demo.payload.Users.getTeacherForStudent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtDTO {

    @JsonProperty("admin_permissions")
    private String adminPermissions;

    public String getAdminPermissions() {
        return adminPermissions;
    }

    public void setAdminPermissions(String adminPermissions) {
        this.adminPermissions = adminPermissions;
    }
}
