package com.hyperprof.curso.core.repositories;

import com.hyperprof.curso.core.models.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Alunos, Long> {


}
