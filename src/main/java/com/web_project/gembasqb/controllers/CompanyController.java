package com.web_project.gembasqb.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.web_project.gembasqb.dtos.CompanyRDto;
import com.web_project.gembasqb.models.CompanyModel;
import com.web_project.gembasqb.repositories.CompanyRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class CompanyController {
    
   @Autowired
   CompanyRepository companyRepository;

   @PostMapping("/companys")
   public ResponseEntity<CompanyModel> saveCompany(@RequestBody @Valid CompanyRDto companyRDto) {
      var companyModel = new CompanyModel();
      BeanUtils.copyProperties(companyRDto, companyModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(companyRepository.save(companyModel));
   }

}
