package com.web_project.gembasqb.models;

public enum UserRole {
    
    ADMIN("Admin"),
    USER("user");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
