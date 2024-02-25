package com.web_project.gembasqb.services;

import org.springframework.stereotype.Service;

import com.web_project.gembasqb.repositories.CollabRepository;

@Service
public class CollabService {
    final CollabRepository collabRepository;

    public CollabService(CollabRepository collabRepository) {
        this.collabRepository = collabRepository;
    }

    
}
