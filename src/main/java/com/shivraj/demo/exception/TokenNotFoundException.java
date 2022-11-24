package com.shivraj.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TokenNotFoundException extends RuntimeException  {

    private String resourceName;
    private String fieldName;
    private String fieldValue;

    public TokenNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found for the Redirect url or %s : %s",resourceName , fieldName ,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }
}
