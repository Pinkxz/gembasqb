package com.web_project.gembasqb.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web_project.gembasqb.models.ServicosModel;


@Repository
public interface ServicosRepository extends JpaRepository<ServicosModel, UUID>{
    
}
