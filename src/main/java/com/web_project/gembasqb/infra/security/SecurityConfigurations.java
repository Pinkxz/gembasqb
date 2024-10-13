package com.web_project.gembasqb.infra.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
    @Autowired
    SecurityFilter securityFilter;

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
            .cors(cors -> cors.configurationSource(request -> {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(List.of("http://localhost:5173")); 
                config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE")); 
                config.setAllowedHeaders(List.of("*"));
                config.setAllowCredentials(true);
                return config;
            }))
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/users").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/users").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/users").denyAll()
                
                .requestMatchers(HttpMethod.POST, "/colaboradores").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/colaboradores").permitAll()
                .requestMatchers(HttpMethod.GET, "/colaboradores").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/colaboradores").hasRole("ADMIN")

                .requestMatchers(HttpMethod.POST, "/clientes").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/clientes").permitAll()
                .requestMatchers(HttpMethod.PUT, "/clientes").permitAll()
                .requestMatchers(HttpMethod.GET, "/clientes").permitAll()

                .requestMatchers(HttpMethod.POST, "/produtos").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/produtos").permitAll()
                .requestMatchers(HttpMethod.GET, "/produtos").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/produtos").hasRole("ADMIN")


                .requestMatchers(HttpMethod.POST, "/companys").permitAll()
                .requestMatchers(HttpMethod.GET, "/companys").denyAll()
                .requestMatchers(HttpMethod.DELETE, "/companys").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/companys").hasRole("ADMIN")

                .requestMatchers(HttpMethod.POST, "/servicos").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/servicos").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/servicos").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/servicos").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
}

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}