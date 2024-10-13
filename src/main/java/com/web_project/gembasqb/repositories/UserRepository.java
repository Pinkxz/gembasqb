package com.web_project.gembasqb.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.web_project.gembasqb.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID>{

    UserDetails findByLogin(String login);
    
}
