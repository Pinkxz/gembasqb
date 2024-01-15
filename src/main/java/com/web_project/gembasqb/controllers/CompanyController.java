package com.web_project.gembasqb.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import com.web_project.gembasqb.dtos.CompanyRDto;
import com.web_project.gembasqb.models.CompanyModel;
import com.web_project.gembasqb.repositories.CompanyRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
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

   @GetMapping("/companys/{id}")
	public ResponseEntity<List<CompanyModel>> getAllCompanys(){
		List<CompanyModel> companyList = companyRepository.findAll();
		if(!companyList.isEmpty()) {
			for(CompanyModel company : companyList) {
				UUID id = company.getId();
				company.add(linkTo(methodOn(CompanyController.class).getOneCompany(id)).withSelfRel());
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(companyList);
	}

	@GetMapping("/companys/{id}")
	public ResponseEntity<Object> getOneCompany(@PathVariable(value="id") UUID id){
		Optional<CompanyModel> companyO = companyRepository.findById(id);
		if(companyO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found.");
		} 
		companyO.get().add(linkTo(methodOn(CompanyController.class).getAllCompanys()).withRel("Company List"));
		return ResponseEntity.status(HttpStatus.OK).body(companyO.get());
	}
   
   @DeleteMapping("/companys/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id) {
		Optional<CompanyModel> companyO = companyRepository.findById(id);
		if(companyO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found.");
		}
		companyRepository.delete(companyO.get());
		return ResponseEntity.status(HttpStatus.OK).body("Company deleted successfully.");
	}
	
	@PutMapping("/companys/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
													  @RequestBody @Valid CompanyRDto companyRDto) {
		Optional<CompanyModel> companyO = companyRepository.findById(id);
		if(companyO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
		}
		var companyModel = companyO.get();
		BeanUtils.copyProperties(companyRDto, companyModel);
		return ResponseEntity.status(HttpStatus.OK).body(companyRepository.save(companyModel));
	}

}
