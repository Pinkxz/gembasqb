package com.web_project.gembasqb.services;

import org.springframework.stereotype.Service;

import com.web_project.gembasqb.repositories.CaixaRepository;

@Service
public class CaixaServices {
    final CaixaRepository caixaRepository;

    public CaixaServices(CaixaRepository caixaRepository) {
        this.caixaRepository = caixaRepository;
    }


    
}
