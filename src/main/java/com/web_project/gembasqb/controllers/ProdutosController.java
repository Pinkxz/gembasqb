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

import com.web_project.gembasqb.dtos.ProdutosRDto;
import com.web_project.gembasqb.models.ProdutosModel;
import com.web_project.gembasqb.repositories.ProdutosRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


import jakarta.validation.Valid;


@RestController
public class ProdutosController {

    @Autowired
    ProdutosRepository produtosRepository;

   @PostMapping("/produtos")
   public ResponseEntity<ProdutosModel> saveProduto(@RequestBody @Valid ProdutosRDto produtosRDto) {
      var produtosModel = new ProdutosModel();
      BeanUtils.copyProperties(produtosRDto, produtosModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produtosModel));
   }

   @GetMapping("/colaboradores/")
	public ResponseEntity<List<ProdutosModel>> getAllProdutos(){
		List<ProdutosModel> produtosList = produtosRepository.findAll();
		if(!produtosList.isEmpty()) {
			for(ProdutosModel produto : produtosList) {
				UUID id = produto.getIdProduto();
				produto.add(linkTo(methodOn(ProdutosController.class).getOneProduto(id)).withSelfRel());
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(produtosList);
	}

	@GetMapping("/colaboradores/{id}")
	public ResponseEntity<Object> getOneProduto(@PathVariable(value="id") UUID id){
		Optional<ProdutosModel> produtosO = produtosRepository.findById(id);
		if(produtosO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto not found.");
		}
		produtosO.get().add(linkTo(methodOn(ProdutosController.class).getAllProdutos()).withRel("Produto List"));
		return ResponseEntity.status(HttpStatus.OK).body(produtosO.get());
	}
   
   @DeleteMapping("/colaboradores/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id) {
		Optional<ProdutosModel> produtosO = produtosRepository.findById(id);
		if(produtosO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto not found.");
		}
		produtosRepository.delete(produtosO.get());
		return ResponseEntity.status(HttpStatus.OK).body("Produto deleted successfully.");
	}
	
	@PutMapping("/colaboradores/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
													  @RequestBody @Valid ProdutosRDto produtosRDto) {
		Optional<ProdutosModel> produtosO = produtosRepository.findById(id);
		if(produtosO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produtos not found.");
		}
		var produtosModel = produtosO.get();
		BeanUtils.copyProperties(produtosRDto, produtosModel);
		return ResponseEntity.status(HttpStatus.OK).body(produtosRepository.save(produtosModel));
	}
}
