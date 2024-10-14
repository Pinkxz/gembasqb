package com.web_project.gembasqb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record ServicosRDto(
    @NotBlank(message = "O nome do serviço não pode estar em branco.")
    String nomeServico,

    @Size(max = 50)
    String descricao,

    @NotNull(message = "O preço não pode ser nulo.")
    float preco,

    @NotBlank(message = "A categoria não pode estar em branco.")
    String categoria,

    @NotNull(message = "O tempo não pode ser nulo.")
    float tempo,

    @NotBlank(message = "O status não pode estar em branco.")
    String status,

    @NotBlank(message = "A imagem não pode estar em branco.")
    String imagem,

    @NotNull(message = "A comissão não pode ser nula.")
    int comissao,

    String fidelidade
) {
}
