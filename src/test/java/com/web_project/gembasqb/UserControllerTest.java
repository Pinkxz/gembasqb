package com.web_project.gembasqb;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.web_project.gembasqb.controllers.UserController;
import com.web_project.gembasqb.dtos.UserRDto;
import com.web_project.gembasqb.models.UserModel;
import com.web_project.gembasqb.models.UserRole;
import com.web_project.gembasqb.repositories.UserRepository;

public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testGetAllUsers() throws Exception {
        when(userRepository.findAll()).thenReturn(List.of(new UserModel("login", "password", 12345678901.0, "Nome", UserRole.USER)));

        mockMvc.perform(get("/getAll/users/"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testRegisterUser() throws Exception {
        UserRDto userDto = new UserRDto("login", "Password1", "12345678901", "Nome", UserRole.USER);
        when(userRepository.findByLogin(userDto.login())).thenReturn(null);

        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"login\":\"login\",\"password\":\"Password1\",\"numero\":\"12345678901\",\"nome\":\"Nome\",\"role\":\"USER\"}"))
            .andExpect(status().isOk());

        verify(userRepository, times(1)).save(any(UserModel.class));
    }

    @Test
void testGetOneUserSuccess() throws Exception {
    UUID userId = UUID.randomUUID();
    UserModel user = new UserModel("login", "password", 12345678901.0, "Nome", UserRole.USER);
    user.setIdUser(userId);
    when(userRepository.findById(userId)).thenReturn(Optional.of(user));

    mockMvc.perform(get("/getOne/users/{id}", userId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.login").value("login"));
}

@Test
void testGetOneUserNotFound() throws Exception {
    UUID userId = UUID.randomUUID();
    when(userRepository.findById(userId)).thenReturn(Optional.empty());

    mockMvc.perform(get("/getOne/users/{id}", userId))
        .andExpect(status().isNotFound())
        .andExpect(content().string("User not found."));
}

@Test
void testUpdateUserSuccess() throws Exception {
    UUID userId = UUID.randomUUID();
    UserModel existingUser = new UserModel("login", "password", 12345678901.0, "Nome", UserRole.USER);
    existingUser.setIdUser(userId);
    when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));

    UserRDto updatedUserDto = new UserRDto("newLogin", "NewPassword1", "12345678901", "New Nome", UserRole.USER);

    mockMvc.perform(put("/upd/users/{id}", userId)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"login\":\"newLogin\",\"password\":\"NewPassword1\",\"numero\":\"12345678901\",\"nome\":\"New Nome\",\"role\":\"USER\"}"))
        .andExpect(status().isOk());

    verify(userRepository, times(1)).save(existingUser);
}

        @Test
        void testUpdateUserNotFound() throws Exception {
            UUID userId = UUID.randomUUID();
            when(userRepository.findById(userId)).thenReturn(Optional.empty());

            UserRDto updatedUserDto = new UserRDto("newLogin", "NewPassword1", "12345678901", "New Nome", UserRole.USER);

            mockMvc.perform(put("/upd/users/{id}", userId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"login\":\"newLogin\",\"password\":\"NewPassword1\",\"numero\":\"12345678901\",\"nome\":\"New Nome\",\"role\":\"USER\"}"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found."));
        }

        @Test
        void testDeleteUserSuccess() throws Exception {
            UUID userId = UUID.randomUUID();
            UserModel existingUser = new UserModel("login", "password", 12345678901.0, "Nome", UserRole.USER);
            existingUser.setIdUser(userId);
            when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));

            mockMvc.perform(delete("/del/users/{id}", userId))
                .andExpect(status().isOk())
                .andExpect(content().string("User deleted successfully."));

            verify(userRepository, times(1)).delete(existingUser);
        }

        @Test
        void testDeleteUserNotFound() throws Exception {
            UUID userId = UUID.randomUUID();
            when(userRepository.findById(userId)).thenReturn(Optional.empty());

            mockMvc.perform(delete("/del/users/{id}", userId))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found."));
        }

}