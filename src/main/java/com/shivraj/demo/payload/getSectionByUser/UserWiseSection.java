package com.shivraj.demo.payload.getSectionByUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;


@JsonIgnoreProperties(ignoreUnknown = true)
public class UserWiseSection {
    public Datum[] data;
    public Link[] links;

    public UserWiseSection() {
        super();
    }

    public UserWiseSection(Datum[] data, Link[] links) {
        this.data = data;
        this.links = links;
    }

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
}
