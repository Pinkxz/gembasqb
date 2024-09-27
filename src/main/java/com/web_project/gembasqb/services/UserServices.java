package com.web_project.gembasqb.services;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;


import com.web_project.gembasqb.models.UserModel;
import com.web_project.gembasqb.repositories.UserRepository;

@Service
public class UserServices {

    final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Cria uma instância do BCryptPasswordEncoder
    }

    public void registerUser(String email, String password, double numero, String nome) {
        String hashedPassword = passwordEncoder.encode(password); // Hash da senha
        UserModel user = new UserModel(email, hashedPassword, numero, nome); // Cria o objeto UserModel
        userRepository.save(user); // Salva o usuário no repositório
    }
    

    public boolean verifyUser(String email, String password) {
        Optional<UserModel> userOptional = userRepository.findByEmail(email); // Obtém o usuário pelo email
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get(); // Obtém o UserModel do Optional
            return passwordEncoder.matches(password, user.getPassword()); // Verifica a senha
        }
        return false; // Retorna falso se o usuário não existir
    }
    

}
