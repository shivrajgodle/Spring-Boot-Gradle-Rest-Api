package com.shivraj.demo.service;


import com.shivraj.demo.payload.terms.getAllTerms.AllTerms;
import com.shivraj.demo.payload.terms.getDistrictForTerms.GetDistrictForTerms;
import com.shivraj.demo.payload.terms.getSchoolForTerms.GetSchoolsForTerms;
import com.shivraj.demo.payload.terms.getTermsById.GetTermsById;

import java.io.IOException;

public interface TermsService {


    public AllTerms getAllTerms(String token , Integer limit , String starting_after) throws IOException;

    public GetTermsById getTermsById(String token , String id) throws IOException;

    public GetDistrictForTerms getDistrictForTerms(String token , String id) throws IOException;

    public GetSchoolsForTerms getSchoolsForTerms(String token , String id , Integer limit , String starting_after) throws IOException;
}
