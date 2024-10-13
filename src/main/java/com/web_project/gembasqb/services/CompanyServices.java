package com.web_project.gembasqb.services;

import org.springframework.stereotype.Service;

import com.web_project.gembasqb.repositories.CompanyRepository;

@Service
public class CompanyServices {
     
    
    final CompanyRepository companyRepository;        

    public CompanyServices(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

}
