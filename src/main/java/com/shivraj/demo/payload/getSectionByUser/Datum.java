package com.shivraj.demo.payload.getSectionByUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Datum {
    private Data data;
    private String uri;

    public Datum() {
        super();
    }

    public Datum(Data data, String uri) {
        this.data = data;
        this.uri = uri;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
