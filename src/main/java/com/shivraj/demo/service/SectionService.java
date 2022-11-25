package com.shivraj.demo.service;

import com.shivraj.demo.payload.sections.getAllSection.AllSection;

import java.io.IOException;

public interface SectionService {
    public AllSection getAllSection(String token) throws IOException;
}
