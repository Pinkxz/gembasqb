package com.web_project.gembasqb;

import com.web_project.gembasqb.controllers.CompanyController;
import com.web_project.gembasqb.dtos.CompanyRDto;
import com.web_project.gembasqb.models.CompanyModel;
import com.web_project.gembasqb.repositories.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class CompanyControllerTest {

    @InjectMocks
    private CompanyController companyController;

    @Mock
    private CompanyRepository companyRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCompany() {
        CompanyRDto companyRDto = new CompanyRDto("Empresa", "empresa boa", "12345-379" , "B", "GO", "ANAPOLIS", "PEQUENA", 32, "SLA", null);
        
        CompanyModel savedCompany = new CompanyModel();
        when(companyRepository.save(any(CompanyModel.class))).thenReturn(savedCompany);

        ResponseEntity<CompanyModel> response = companyController.saveCompany(companyRDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedCompany, response.getBody());
    }

    @Test
    void testGetAllCompanies() {
        CompanyModel company = new CompanyModel(null, "Empresa", "empresa boa", "12345-379" , "B", "central",  32,"ANAPOLIS", "GO", "pequena");
        when(companyRepository.findAll()).thenReturn(Collections.singletonList(company));

        ResponseEntity<List<CompanyModel>> response = companyController.getAllCompanys();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testGetOneCompany() {
        UUID id = UUID.randomUUID();
        CompanyModel company = new CompanyModel();
        when(companyRepository.findById(id)).thenReturn(Optional.of(company));

        ResponseEntity<Object> response = companyController.getOneCompany(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(company, response.getBody());
    }

    @Test
    void testDeleteCompany() {
        UUID id = UUID.randomUUID();
        CompanyModel company = new CompanyModel();
        when(companyRepository.findById(id)).thenReturn(Optional.of(company));

        ResponseEntity<Object> response = companyController.deleteCompany(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(companyRepository).delete(company);
    }

    @Test
    void testUpdateCompany() {
        UUID id = UUID.randomUUID();
        CompanyRDto companyRDto = new CompanyRDto("Empresa", "empresa boa", "12345-379" , "B", "GO", "ANAPOLIS", "PEQUENA", 32, "SLA", id);

        CompanyModel existingCompany = new CompanyModel();
        when(companyRepository.findById(id)).thenReturn(Optional.of(existingCompany));
        when(companyRepository.save(any(CompanyModel.class))).thenReturn(existingCompany);

        ResponseEntity<Object> response = companyController.updateCompany(id, companyRDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
