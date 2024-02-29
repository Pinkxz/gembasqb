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

import com.web_project.gembasqb.dtos.CaixaRDto;
import com.web_project.gembasqb.models.CaixaModel;
import com.web_project.gembasqb.repositories.CaixaRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class CaixaController {
    
   @Autowired
   CaixaRepository caixaRepository;

   @PostMapping("/caixas")
   public ResponseEntity<CaixaModel> saveCaixa(@RequestBody @Valid CaixaRDto caixaRDto) {
      var caixaModel = new CaixaModel();
      BeanUtils.copyProperties(caixaRDto, caixaModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(caixaRepository.save(caixaModel));
   }

   @GetMapping("/caixas/")
   public ResponseEntity<List<CaixaModel>> getAllCaixas(){
      List<CaixaModel> caixaList = caixaRepository.findAll();
      if(!caixaList.isEmpty()) {
         for(CaixaModel caixa : caixaList) {
            UUID id = caixa.getCaixaId();
            caixa.add(linkTo(methodOn(CaixaController.class).getOneCaixa(id)).withSelfRel());
         }
      }
      return ResponseEntity.status(HttpStatus.OK).body(caixaList);
   }

   @GetMapping("/caixas/{id}")
   public ResponseEntity<Object> getOneCaixa(@PathVariable(value="id") UUID id){
      Optional<CaixaModel> caixaO = caixaRepository.findById(id);
      if(caixaO.isEmpty()) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Caixas not found.");
      } 
      caixaO.get().add(linkTo(methodOn(CaixaController.class).getAllCaixas()).withRel("Caixa List"));
      return ResponseEntity.status(HttpStatus.OK).body(caixaO.get());
   }
   
   @DeleteMapping("/caixas/{id}")
   public ResponseEntity<Object> deleteCaixa(@PathVariable(value="id") UUID id) {
      Optional<CaixaModel> caixaO = caixaRepository.findById(id);
      if(caixaO.isEmpty()) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Caixa not found.");
      }
      caixaRepository.delete(caixaO.get());
      return ResponseEntity.status(HttpStatus.OK).body("Caixa deleted successfully.");
   }
   
   @PutMapping("/caixas/{id}")
   public ResponseEntity<Object> updateCaixa(@PathVariable(value="id") UUID id,
                                             @RequestBody @Valid CaixaRDto caixaRDto) {
      Optional<CaixaModel> caixaO = caixaRepository.findById(id);
      if(caixaO.isEmpty()) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Caixa not found.");
      }
      var caixaModel = caixaO.get();
      BeanUtils.copyProperties(caixaRDto, caixaModel);
      return ResponseEntity.status(HttpStatus.OK).body(caixaRepository.save(caixaModel));
   }

}

