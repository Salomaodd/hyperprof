package com.hyperprof.curso.api.alunos.mappers;

import com.hyperprof.curso.api.alunos.dtos.AlunoRequest;
import com.hyperprof.curso.api.alunos.dtos.AlunoResponse;
import com.hyperprof.curso.core.models.Aluno;

public interface AlunoMapper {

    Aluno toAluno(AlunoRequest alunoRequest);
    AlunoResponse toAlunoResponse(Aluno aluno);
}
