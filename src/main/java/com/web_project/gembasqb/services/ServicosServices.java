package com.web_project.gembasqb.services;

import org.springframework.stereotype.Service;

import com.web_project.gembasqb.repositories.ServicosRepository;
@Service
public class ServicosServices {
    final ServicosRepository ServicosRepository;

    public ServicosServices(ServicosRepository servicosRepository) {
        ServicosRepository = servicosRepository;
    }

    
}
