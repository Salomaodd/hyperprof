package com.hyperprof.curso.api.alunos.mappers;

import com.hyperprof.curso.api.alunos.dtos.AlunoRequest;
import com.hyperprof.curso.api.alunos.dtos.AlunoResponse;
import com.hyperprof.curso.core.models.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapperImpl implements AlunoMapper{

    @Override
    public Aluno toAluno(AlunoRequest alunoRequest) {
        if (alunoRequest == null) {
            return null;
        }

        return Aluno.builder()
                .nome(alunoRequest.getNome())
                .email(alunoRequest.getEmail())
                .dataAula(alunoRequest.getDataAula())
                .build();
    }

    @Override
    public AlunoResponse toAlunoResponse(Aluno aluno) {
        if (aluno == null) {
            return null;
        }

        return AlunoResponse.builder()
                .id(aluno.getId())
                .nome(aluno.getNome())
                .email(aluno.getEmail())
                .dataAula(aluno.getDataAula())
                .createdAt(aluno.getCreatedAt())
                .updatedAt(aluno.getUpdatedAt())
                .build();
    }
}
