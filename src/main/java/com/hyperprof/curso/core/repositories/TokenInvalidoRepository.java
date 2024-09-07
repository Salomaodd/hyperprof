package com.hyperprof.curso.core.repositories;

import com.hyperprof.curso.core.models.TokenInvalido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenInvalidoRepository extends JpaRepository<TokenInvalido, Long> {

    boolean existsByToken(String token);

}
