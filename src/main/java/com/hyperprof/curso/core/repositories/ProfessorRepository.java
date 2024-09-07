package com.hyperprof.curso.core.repositories;

import com.hyperprof.curso.core.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    List<Professor> findByDescricao(String descricao);
    Optional<Professor> findByEmail(String email);
    boolean existsByEmail(String email);
    List<Professor> findByDescricaoContaining(String descricao);
}
