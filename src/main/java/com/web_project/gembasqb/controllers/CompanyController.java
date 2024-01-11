package com.web_project.gembasqb.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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

   @GetMapping("/companys")
   public ResponseEntity<List<CompanyModel>> getAlCompanys() {
       return ResponseEntity.status(HttpStatus.OK).body(companyRepository.findAll());
   }
   
   @GetMapping("/companys/{id}")
   public ResponseEntity<Object> getOneCompany(@PathVariable(value="id") UUID id) {
      Optional<CompanyModel> company0 = companyRepository.findById(id);
      if(company0.isEmpty()){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not Found");
      }
      return ResponseEntity.status(HttpStatus.OK).body(company0.get());
   }
   

}
