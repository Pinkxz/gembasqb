package com.web_project.gembasqb.services;

import org.springframework.stereotype.Service;

import com.web_project.gembasqb.repositories.ProdutosRepositoy;

@Service
public class ProdutosServices {
    final ProdutosRepositoy produtosRepositoy;

    public ProdutosServices(ProdutosRepositoy produtosRepositoy) {
        this.produtosRepositoy = produtosRepositoy;
    }

    
    
}
