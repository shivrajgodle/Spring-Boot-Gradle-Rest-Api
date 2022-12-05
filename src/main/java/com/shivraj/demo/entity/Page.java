package com.shivraj.demo.entity;

public class Page {

    private String starting_after;

    public String getStarting_after() {
        return starting_after;
    }

    public void setStarting_after(String starting_after) {
        this.starting_after = starting_after;
    }

    public Page() {
        super();
    }

    public Page(String starting_after) {
        this.starting_after = starting_after;
    }

    @Override
    public String toString() {
        return "Page{" +
                "starting_after='" + starting_after + '\'' +
                '}';
    }
}
