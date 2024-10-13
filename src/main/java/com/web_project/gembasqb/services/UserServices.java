package com.web_project.gembasqb.services;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import java.util.Optional;


import com.web_project.gembasqb.models.UserModel;
import com.web_project.gembasqb.models.UserRole;

import com.web_project.gembasqb.repositories.UserRepository;

@Service
public class UserServices implements UserDetailsService {

    @Autowired
    final UserRepository userRepository;
    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;

     public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Cria uma instância do BCryptPasswordEncoder
    }
 
    public void registerUser(String login, String password, double numero, String nome, UserRole role) {
        String hashedPassword = passwordEncoder.encode(password); // Hash da senha
        UserModel user = new UserModel(login, hashedPassword, numero, nome, role); // Cria o objeto UserModel
        userRepository.save(user); // Salva o usuário no repositório
    }
    

   /*  public boolean verifyUser(String login, String password) {
        Optional<UserModel> userOptional = userRepository.findByLogin(login); // Obtém o usuário pelo login
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get(); // Obtém o UserModel do Optional
            return passwordEncoder.matches(password, user.getPassword()); // Verifica a senha
        }
        return false; // Retorna falso se o usuário não existir
    }
    */
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login);
    }

    
}

