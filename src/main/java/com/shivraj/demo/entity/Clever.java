package com.shivraj.demo.entity;

public class Clever {

    private String code;
    private String grant_type;
    private String redirect_uri;

    public Clever() {
        super();
    }

    public Clever(String code, String grant_type, String redirect_uri) {
        this.code = code;
        this.grant_type = grant_type;
        this.redirect_uri = redirect_uri;
    }

    @Override
    public String toString() {
        return "Clever{" +
                "code='" + code + '\'' +
                ", grant_type='" + grant_type + '\'' +
                ", redirect_uri='" + redirect_uri + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }
}
