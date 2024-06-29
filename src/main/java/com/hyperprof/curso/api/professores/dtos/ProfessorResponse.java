package com.hyperprof.curso.api.professores.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorResponse {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String descricao;
    private BigDecimal valorHora;
    private String fotoPerfil;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
