package com.hyperprof.curso.api.professores.services;

import com.hyperprof.curso.api.professores.dtos.ProfessorResponse;
import com.hyperprof.curso.api.professores.mappers.ProfessorMapper;
import com.hyperprof.curso.core.models.AuthenticatedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeServiceImpl implements MeService{

    private final ProfessorMapper professorMapper;

    @Override
    public ProfessorResponse buscarProfessorLogado() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var professor = ((AuthenticatedUser) authentication.getPrincipal()).getProfessor();
        return professorMapper.toProfessorResponse(professor);
    }
}
