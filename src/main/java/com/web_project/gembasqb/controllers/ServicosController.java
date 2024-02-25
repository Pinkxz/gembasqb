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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import com.web_project.gembasqb.dtos.ServicosRDto;
import com.web_project.gembasqb.models.ServicosModel;
import com.web_project.gembasqb.repositories.ServicosRepository;

import jakarta.validation.Valid;

@RestController
public class ServicosController {

    @Autowired
    ServicosRepository servicosRepository;

   @PostMapping("/servicos")
   public ResponseEntity<ServicosModel> saveServico(@RequestBody @Valid ServicosRDto servicosRDto) {
      var servicosModel = new ServicosModel();
      BeanUtils.copyProperties(servicosRDto, servicosModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(servicosRepository.save(servicosModel));
   }

   @GetMapping("/servicos/")
	public ResponseEntity<List<ServicosModel>> getAllServicos(){
		List<ServicosModel> servicosList = servicosRepository.findAll();
		if(!servicosList.isEmpty()) {
			for(ServicosModel servicos : servicosList) {
				UUID id = servicos.getIdServico();
				servicos.add(linkTo(methodOn(ServicosController.class).getOneServico(id)).withSelfRel());
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(servicosList);
	}

	@GetMapping("/servicos/{id}")
	public ResponseEntity<Object> getOneServico(@PathVariable(value="id") UUID id){
		Optional<ServicosModel> servicoO = servicosRepository.findById(id);
		if(servicoO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Servico not found.");
		}
		servicoO.get().add(linkTo(methodOn(ServicosController.class).getAllServicos()).withRel("Servico List"));
		return ResponseEntity.status(HttpStatus.OK).body(servicoO.get());
	}
   
   @DeleteMapping("/servicos/{id}")
	public ResponseEntity<Object> deleteServico(@PathVariable(value="id") UUID id) {
		Optional<ServicosModel> servicoO = servicosRepository.findById(id);
		if(servicoO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Servico not found.");
		}
		servicosRepository.delete(servicoO.get());
		return ResponseEntity.status(HttpStatus.OK).body("Servico deleted successfully.");
	}
	
	@PutMapping("/servicos/{id}")
	public ResponseEntity<Object> updateServico(@PathVariable(value="id") UUID id,
													  @RequestBody @Valid ServicosRDto servicosRDto) {
		Optional<ServicosModel> servico0 = servicosRepository.findById(id);
		if(servico0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Servico not found.");
		}
		var servicosModel = servico0.get();
		BeanUtils.copyProperties(servicosRDto, servicosModel);
		return ResponseEntity.status(HttpStatus.OK).body(servicosRepository.save(servicosModel));
	}
}
