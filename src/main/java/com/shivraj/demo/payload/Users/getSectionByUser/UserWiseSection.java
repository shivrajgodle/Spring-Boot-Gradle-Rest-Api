package com.shivraj.demo.payload.Users.getSectionByUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Arrays;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserWiseSection {
    public Datum[] data;
    public Link[] links;



    public Datum[] getData() {
        return data;
    }

    public void setData(Datum[] data) {
        this.data = data;
    }

    public Link[] getLinks() {
        return links;
    }

    public void setLinks(Link[] links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "UserWiseSection{" +
                "data=" + Arrays.toString(data) +
                ", links=" + Arrays.toString(links) +
                '}';
    }
}
