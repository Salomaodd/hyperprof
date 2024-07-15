package com.hyperprof.curso.core.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Entity
@Table(name = "professores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Professor extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ToString.Include
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor_hora")
    private BigDecimal valorHora;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @Column(name = "password")
    private String password;

}
