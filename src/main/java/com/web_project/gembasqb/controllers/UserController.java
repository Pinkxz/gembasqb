package com.web_project.gembasqb.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
