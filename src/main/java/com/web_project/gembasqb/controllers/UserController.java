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


import com.web_project.gembasqb.dtos.UserRDto;
import com.web_project.gembasqb.models.UserModel;
import com.web_project.gembasqb.repositories.UserRepository;

import jakarta.validation.Valid;


@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

   @PostMapping("/users")
   public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRDto userRDto) {
      var userModel = new UserModel();
      BeanUtils.copyProperties(userRDto, userModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));
   }

   @GetMapping("/users/")
	public ResponseEntity<List<UserModel>> getAllUsers(){
		List<UserModel> userList = userRepository.findAll();
		if(!userList.isEmpty()) {
			for(UserModel user : userList) {
				UUID id = user.getIdUser();
				user.add(linkTo(methodOn(UserController.class).getOneUser(id)).withSelfRel());
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(userList);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Object> getOneUser(@PathVariable(value="id") UUID id){
		Optional<UserModel> userO = userRepository.findById(id);
		if(userO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		}
		userO.get().add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("User List"));
		return ResponseEntity.status(HttpStatus.OK).body(userO.get());
	}
   
   @DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable(value="id") UUID id) {
		Optional<UserModel> userO = userRepository.findById(id);
		if(userO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		}
		userRepository.delete(userO.get());
		return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable(value="id") UUID id,
													  @RequestBody @Valid UserRDto userRDto) {
		Optional<UserModel> user0 = userRepository.findById(id);
		if(user0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		}
		var userModel = user0.get();
		BeanUtils.copyProperties(userRDto, userModel);
		return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(userModel));
	}
}
