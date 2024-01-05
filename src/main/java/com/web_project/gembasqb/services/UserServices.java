package com.web_project.gembasqb.services;

import org.springframework.stereotype.Service;

import com.web_project.gembasqb.repositories.UserRepository;

@Service
public class UserServices {

    final UserRepository userRepository;        

    public UserServices(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
