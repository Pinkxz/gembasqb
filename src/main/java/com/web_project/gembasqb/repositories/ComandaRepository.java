package com.web_project.gembasqb.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web_project.gembasqb.models.ComandaModel;

@Repository
public interface ComandaRepository extends JpaRepository<ComandaModel, UUID>{
    
}
