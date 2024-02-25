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

import com.web_project.gembasqb.dtos.ClientesRDto;
import com.web_project.gembasqb.models.ClientesModel;
import com.web_project.gembasqb.repositories.ClientesRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ClientesController {
    
   @Autowired
   ClientesRepository clientesRepository;

   @PostMapping("/clientes")
   public ResponseEntity<ClientesModel> saveCliente(@RequestBody @Valid ClientesRDto clientesRDto) {
      var clientesModel = new ClientesModel();
      BeanUtils.copyProperties(clientesRDto, clientesModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(clientesRepository.save(clientesModel));
   }

   @GetMapping("/c/")
	public ResponseEntity<List<ClientesModel>> getAllClientes(){
		List<ClientesModel> clientesList = clientesRepository.findAll();
		if(!clientesList.isEmpty()) {
			for(ClientesModel clientes : clientesList) {
				UUID id = clientes.getIdCliente();
				clientes.add(linkTo(methodOn(ClientesController.class).getOneCliente(id)).withSelfRel());
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(clientesList);
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<Object> getOneCliente(@PathVariable(value="id") UUID id){
		Optional<ClientesModel> clientesO = clientesRepository.findById(id);
		if(clientesO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clientes not found.");
		} 
		clientesO.get().add(linkTo(methodOn(ClientesController.class).getAllClientes()).withRel("Cliente List"));
		return ResponseEntity.status(HttpStatus.OK).body(clientesO.get());
	}
   
   @DeleteMapping("/clientes/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id) {
		Optional<ClientesModel> clienteO = clientesRepository.findById(id);
		if(clienteO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente not found.");
		}
		clientesRepository.delete(clienteO.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cliente deleted successfully.");
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
													  @RequestBody @Valid ClientesRDto clientesRDto) {
		Optional<ClientesModel> clientesO = clientesRepository.findById(id);
		if(clientesO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente not found.");
		}
		var clientesModel = clientesO.get();
		BeanUtils.copyProperties(clientesRDto, clientesModel);
		return ResponseEntity.status(HttpStatus.OK).body(clientesRepository.save(clientesModel));
	}

}
