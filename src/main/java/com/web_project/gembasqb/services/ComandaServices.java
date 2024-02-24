package com.web_project.gembasqb.services;

import org.springframework.stereotype.Service;

import com.web_project.gembasqb.repositories.ComandaRepository;

@Service
public class ComandaServices {
    final ComandaRepository comandaRepository;

    public ComandaServices(ComandaRepository comandaRepository) {
        this.comandaRepository = comandaRepository;
    }

    
}
