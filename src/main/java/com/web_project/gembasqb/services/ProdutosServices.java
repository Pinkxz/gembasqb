package com.web_project.gembasqb.services;

import org.springframework.stereotype.Service;

import com.web_project.gembasqb.repositories.ProdutosRepository;

@Service
public class ProdutosServices {
    final ProdutosRepository produtosRepositoy;

    public ProdutosServices(ProdutosRepository produtosRepositoy) {
        this.produtosRepositoy = produtosRepositoy;
    }

    
    
}
