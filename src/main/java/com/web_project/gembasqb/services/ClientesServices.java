package com.web_project.gembasqb.services;

import org.springframework.stereotype.Service;

import com.web_project.gembasqb.repositories.ClientesRepository;

@Service
public class ClientesServices {

    final ClientesRepository clientesRepository;

    public ClientesServices(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    
    
}
