package com.hyperprof.curso.core.repositories;

import com.hyperprof.curso.core.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
