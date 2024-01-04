package com.web_project.gembasqb.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.web_project.gembasqb.services.CompanyServices;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/CompanyModel")

public class CompanyController {
    
    final CompanyServices companyServices;

    public CompanyController(CompanyServices companyServices) {
        this.companyServices = companyServices;
    }

    
}
