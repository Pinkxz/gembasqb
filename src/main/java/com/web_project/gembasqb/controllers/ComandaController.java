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

import com.web_project.gembasqb.dtos.ComandaRDto;
import com.web_project.gembasqb.models.ComandaModel;
import com.web_project.gembasqb.repositories.ComandaRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


import jakarta.validation.Valid;


@RestController
public class ComandaController {

    @Autowired
    ComandaRepository comandaRepository;

   @PostMapping("/comandas")
   public ResponseEntity<ComandaModel> saveComanda(@RequestBody @Valid ComandaRDto comandaRDto) {
      var comandaModel = new ComandaModel();
      BeanUtils.copyProperties(comandaRDto, comandaModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(comandaRepository.save(comandaModel));
   }

   @GetMapping("/comandas/")
	public ResponseEntity<List<ComandaModel>> getAllComandas(){
		List<ComandaModel> comandaList = comandaRepository.findAll();
		if(!comandaList.isEmpty()) {
			for(ComandaModel comanda : comandaList) {
				UUID id = comanda.getIdComanda();
				comanda.add(linkTo(methodOn(ComandaController.class).getOneComanda(id)).withSelfRel());
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(comandaList);
	}

	@GetMapping("/comandas/{id}")
	public ResponseEntity<Object> getOneComanda(@PathVariable(value="id") UUID id){
		Optional<ComandaModel> comandaO = comandaRepository.findById(id);
		if(comandaO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comanda not found.");
		}
		comandaO.get().add(linkTo(methodOn(ComandaController.class).getAllComandas()).withRel("Comanda List"));
		return ResponseEntity.status(HttpStatus.OK).body(comandaO.get());
	}
   
   @DeleteMapping("/comandas/{id}")
	public ResponseEntity<Object> deleteComanda(@PathVariable(value="id") UUID id) {
		Optional<ComandaModel> comandaO = comandaRepository.findById(id);
		if(comandaO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comanda not found.");
		}
		comandaRepository.delete(comandaO.get());
		return ResponseEntity.status(HttpStatus.OK).body("Comanda deleted successfully.");
	}
	
	@PutMapping("/comandas/{id}")
	public ResponseEntity<Object> updateComanda(@PathVariable(value="id") UUID id,
													  @RequestBody @Valid ComandaRDto comandaRDto) {
		Optional<ComandaModel> comandaO = comandaRepository.findById(id);
		if(comandaO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comanda not found.");
		}
		var comandaModel = comandaO.get();
		BeanUtils.copyProperties(comandaRDto, comandaModel);
		return ResponseEntity.status(HttpStatus.OK).body(comandaRepository.save(comandaModel));
	}
}
