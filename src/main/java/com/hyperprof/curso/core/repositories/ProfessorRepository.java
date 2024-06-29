package com.hyperprof.curso.core.repositories;

import com.hyperprof.curso.core.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    List<Professor> findByDescricao(String descricao);
}
