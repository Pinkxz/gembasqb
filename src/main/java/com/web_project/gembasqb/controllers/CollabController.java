package com.web_project.gembasqb.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web_project.gembasqb.dtos.CollabRDto;
import com.web_project.gembasqb.models.CollabModel;
import com.web_project.gembasqb.repositories.CollabRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


import jakarta.validation.Valid;


@RestController
public class CollabController {

    @Autowired
    CollabRepository collabRepository;

   @PostMapping("/colaboradores")
   public ResponseEntity<CollabModel> saveCollab(@RequestBody @Valid CollabRDto collabRDto) {
      var collabModel = new CollabModel();
      BeanUtils.copyProperties(collabRDto, collabModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(collabRepository.save(collabModel));
   }

   @GetMapping("/colaboradores/")
	public ResponseEntity<List<CollabModel>> getAllCollabs(){
		List<CollabModel> collabList = collabRepository.findAll();
		if(!collabList.isEmpty()) {
			for(CollabModel collab : collabList) {
				UUID id = collab.getIdCollabUuid();
				collab.add(linkTo(methodOn(CollabController.class).getOneCollab(id)).withSelfRel());
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(collabList);
	}

	@GetMapping("/colaboradores/{id}")
	public ResponseEntity<Object> getOneCollab(@PathVariable(value="id") UUID id){
		Optional<CollabModel> collabO = collabRepository.findById(id);
		if(collabO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Collab not found.");
		}
		collabO.get().add(linkTo(methodOn(CollabController.class).getAllCollabs()).withRel("Collab List"));
		return ResponseEntity.status(HttpStatus.OK).body(collabO.get());
	}
   
   @DeleteMapping("/colaboradores/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id) {
		Optional<CollabModel> collabO = collabRepository.findById(id);
		if(collabO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Collab not found.");
		}
		collabRepository.delete(collabO.get());
		return ResponseEntity.status(HttpStatus.OK).body("Collab deleted successfully.");
	}
	
	@PutMapping("/colaboradores/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
													  @RequestBody @Valid CollabRDto collabRDto) {
		Optional<CollabModel> collab0 = collabRepository.findById(id);
		if(collab0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Collab not found.");
		}
		var collabModel = collab0.get();
		BeanUtils.copyProperties(collabRDto, collabModel);
		return ResponseEntity.status(HttpStatus.OK).body(collabRepository.save(collabModel));
	}
}
