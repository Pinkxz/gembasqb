package com.web_project.gembasqb.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.web_project.gembasqb.services.UserServices;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/UserModel")
public class UserController {

     final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

}
