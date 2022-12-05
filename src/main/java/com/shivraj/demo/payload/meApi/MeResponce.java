package com.shivraj.demo.payload.meApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeResponce {

    private String type;
    private Data data;
    ArrayList< Object > links = new ArrayList < Object > ();

    public MeResponce() {
        super();
    }

    public MeResponce(String type, Data data, ArrayList<Object> links) {
        this.type = type;
        this.data = data;
        this.links = links;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public ArrayList<Object> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<Object> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "MeResponce{" +
                "type='" + type + '\'' +
                ", data=" + data +
                ", links=" + links +
                '}';
    }
}
