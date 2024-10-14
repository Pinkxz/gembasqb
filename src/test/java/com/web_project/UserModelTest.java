package com.web_project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import com.web_project.gembasqb.exceptions.InvalidDataException;
import com.web_project.gembasqb.models.UserModel;
import com.web_project.gembasqb.models.UserRole;

class UserModelTest {

    private static final UserRole UserRole = null;



    @Test
    void testSetLogin() {
        UserModel user = new UserModel();
        assertThrows(InvalidDataException.class, () -> user.setLogin(null));
        assertThrows(InvalidDataException.class, () -> user.setLogin("A".repeat(31))); // Teste com 31 caracteres
        user.setLogin("validLogin");
        assertEquals("validLogin", user.getLogin());
    }

    @Test
    void testSetPassword() {
        UserModel user = new UserModel();
        assertThrows(InvalidDataException.class, () -> user.setPassword(null));
        assertThrows(InvalidDataException.class, () -> user.setPassword("short")); // Menos de 6 caracteres
        user.setPassword("ValidPass1");
        assertEquals("ValidPass1", user.getPassword());
    }

        @Test
        public void testUserModelSetNumero() {
            UserModel user = new UserModel();
            user.setNumero(1234567890); // Um número válido com 11 dígitos
            assertEquals(1234567890, user.getNumero());
        }

        @Test
        void testUserModelSetNome() {
            UserModel user = new UserModel();
            assertThrows(InvalidDataException.class, () -> user.setNome(null)); // Nome nulo
            assertThrows(InvalidDataException.class, () -> user.setNome("A".repeat(31))); // Teste com 31 caracteres
            user.setNome("Nome Válido");
            assertEquals("Nome Válido", user.getNome());
        }



            @Test
            public void testUserModelGetAuthorities() {
                UserModel user = new UserModel("email@g", "senaha", 1234567890, "mateus", UserRole);
                Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
                assertNotNull(authorities);
                
            }


}
