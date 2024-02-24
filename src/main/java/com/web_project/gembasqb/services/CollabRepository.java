package com.web_project.gembasqb.services;

import org.springframework.stereotype.Service;

@Service
public class CollabRepository {
    final CollabRepository collabRepository;

    public CollabRepository(CollabRepository collabRepository) {
        this.collabRepository = collabRepository;
    }

    
}
