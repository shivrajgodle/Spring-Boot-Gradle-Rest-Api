package com.shivraj.demo.service;


import com.shivraj.demo.payload.terms.AllTerms;

import java.io.IOException;

public interface TermsService {

    public AllTerms getAllTerms(String token) throws IOException;
}
