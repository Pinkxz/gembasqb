package com.web_project.gembasqb.controllers;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.web_project.gembasqb.dtos.LoginResponseDTO;
import com.web_project.gembasqb.dtos.AuthenticationDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import com.web_project.gembasqb.dtos.UserRDto;
import com.web_project.gembasqb.infra.security.TokenService;
import com.web_project.gembasqb.models.UserModel;
import com.web_project.gembasqb.repositories.UserRepository;
import com.web_project.gembasqb.services.UserServices;

import jakarta.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServices userServices;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private final PasswordEncoder passwordEncoder; // Use PasswordEncoder ao invés de BCryptPasswordEncoder

    // Injeção de PasswordEncoder (não diretamente o BCryptPasswordEncoder)
    public UserController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/users/")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> userList = userRepository.findAll();
        if (!userList.isEmpty()) {
            for (UserModel user : userList) {
                UUID id = user.getIdUser();
                user.add(linkTo(methodOn(UserController.class).getOneUser(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") UUID id) {
        Optional<UserModel> userO = userRepository.findById(id);
        if (userO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        userO.get().add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("User List"));
        return ResponseEntity.status(HttpStatus.OK).body(userO.get());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") UUID id) {
        Optional<UserModel> userO = userRepository.findById(id);
        if (userO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        userRepository.delete(userO.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") UUID id,
            @RequestBody @Valid UserRDto userRDto) {
        Optional<UserModel> user0 = userRepository.findById(id);
        if (user0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        var userModel = user0.get();
        BeanUtils.copyProperties(userRDto, userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(userModel));
    }

    
    @PostMapping("/auth/register")
    public ResponseEntity register(@RequestBody @Valid UserRDto data){
        if(this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserModel newUser = new UserModel(data.login(), encryptedPassword, Double.parseDouble(data.numero()), data.nome(), data.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

        @PostMapping("/auth/login")
        public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((UserModel) auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
        }

}












  ///Login 2 antigo
 

    /*  @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserModel userModel) {
        String login = userModel.getLogin();
        String password = userModel.getPassword();

        // Verificar no banco de dados se o usuário existe
        Optional<UserModel> userOptional = userRepository.findByLogin(login);
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();

            // Verificar se a senha está correta usando passwordEncoder.matches
            if (passwordEncoder.matches(password, user.getPassword())) {
                // Autenticar o usuário
                var usernamePassword = new UsernamePasswordAuthenticationToken(login, password);
                var auth = this.authenticationManager.authenticate(usernamePassword);

                // Gerar token
                var token = tokenService.generateToken(user);

                // Retornar o token no corpo da resposta
                return ResponseEntity.ok(new LoginResponseDTO(token));
            }
        }

        // Se não encontrou o usuário ou a senha está incorreta
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
    }*/

 /*    ///Login 1 antigo
   @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserModel userModel) {
        String email = userModel.getEmail();
        String password = userModel.getPassword();
        
        // Verificar no banco de dados se o usuário existe e se a senha está correta
        Optional<UserModel> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) { // Usando matches para verificar a senha
                // Login bem-sucedido
                return ResponseEntity.ok("Login bem-sucedido!");
            }
        }
        
        // Se não encontrou o usuário ou a senha está incorreta
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
    }
    */
///Register antigo
       /*  @PostMapping("/users")
     public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRDto userRDto) {
        // Cria uma nova instância do UserModel
        UserModel userModel = new UserModel();
        
        // Copia os dados do UserRDto para o UserModel
        BeanUtils.copyProperties(userRDto, userModel);

        // Usa o método registerUser do UserServices para salvar o usuário com a senha criptografada
        userServices.registerUser(userModel.getEmail(), userModel.getPassword(), userModel.getNumero(), userModel.getNome(), userModel.getRole());

        // Retorna uma resposta com status CREATED
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
*/

   /* @PostMapping("/auth/register")
    public ResponseEntity<UserModel> register(@RequestBody @Valid UserRDto data) {
        // Verificar se o usuário já existe pelo email (login)
        if (this.userRepository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().body(null); // Usuário já existe, retorna 400
        }

        // Criptografar a senha usando o PasswordEncoder injetado
        String encryptedPassword = passwordEncoder.encode(data.password());

        // Cria uma nova instância de UserModel
        UserModel newUser = new UserModel();

        // Copiar propriedades do UserRDto para o UserModel
        BeanUtils.copyProperties(data, newUser);

        // Atualizar a senha criptografada
        newUser.setPassword(encryptedPassword);

        // Salvar o novo usuário no banco de dados
        userServices.registerUser(newUser.getEmail(), newUser.getPassword(), newUser.getNumero(), newUser.getNome(), newUser.getRole());

        // Retornar uma resposta com status CREATED
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }*/