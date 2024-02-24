package com.web_project.gembasqb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutosRDto(@NotBlank String nomeProduto, String descricaoProduto, @NotNull int precoProduto,
    @NotNull int pesoProduto, String categoriaProduto, @NotBlank String statusProduto, @NotBlank String fotoProduto) {
    
}
