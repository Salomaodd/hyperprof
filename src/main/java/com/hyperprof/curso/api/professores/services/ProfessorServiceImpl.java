package com.hyperprof.curso.api.professores.services;

import com.hyperprof.curso.api.professores.dtos.ProfessorResponse;
import com.hyperprof.curso.api.professores.mappers.ProfessorMapper;
import com.hyperprof.curso.core.exceptions.ProfessorNotFoundException;
import com.hyperprof.curso.core.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService{

    private ProfessorRepository professorRepository;
    private ProfessorMapper professorMapper;

    @Override
    public List<ProfessorResponse> buscarProfessores(String descricao) {
        return professorRepository.findByDescricao(descricao)
                .stream()
                .map(professorMapper::toProfessorResponse)
                .toList();
    }

    @Override
    public ProfessorResponse buscarProfessorPorId(Long professorId) {
        return professorRepository.findById(professorId)
                .map(professorMapper::toProfessorResponse)
                .orElseThrow(ProfessorNotFoundException::new);
    }
}
