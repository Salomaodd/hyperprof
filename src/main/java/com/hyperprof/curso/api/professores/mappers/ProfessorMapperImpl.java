package com.hyperprof.curso.api.professores.mappers;

import com.hyperprof.curso.api.professores.dtos.ProfessorRequest;
import com.hyperprof.curso.api.professores.dtos.ProfessorResponse;
import com.hyperprof.curso.core.models.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapperImpl implements ProfessorMapper {

    @Override
    public Professor toProfessor(ProfessorRequest professorRequest) {
        if (professorRequest == null) {
            return null;
        }
        return Professor.builder()
                .nome(professorRequest.getNome())
                .email(professorRequest.getEmail())
                .idade(professorRequest.getIdade())
                .descricao(professorRequest.getDescricao())
                .valorHora(professorRequest.getValorHora())
                .password(professorRequest.getPassword())
                .build();
    }

    @Override
    public ProfessorResponse toProfessorResponse(Professor professor) {
        if (professor == null) {
            return null;
        }

        return ProfessorResponse.builder()
                .id(professor.getId())
                .nome(professor.getNome())
                .email(professor.getEmail())
                .idade(professor.getIdade())
                .descricao(professor.getDescricao())
                .valorHora(professor.getValorHora())
                .fotoPerfil(professor.getFotoPerfil())
                .createdAt(professor.getCreatedAt())
                .updatedAt(professor.getUpdatedAt())
                .build();
    }
}
