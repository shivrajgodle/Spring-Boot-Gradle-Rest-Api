package com.shivraj.demo.payload.terms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllTerms {
    private List<NewData> data;

    private List<Links> links;

    public List<NewData> getData() {
        return data;
    }

    public void setData(List<NewData> data) {
        this.data = data;
    }

    public List<Links> getLinks() {
        return links;
    }

    public void setLinks(List<Links> links) {
        this.links = links;
    }
}
