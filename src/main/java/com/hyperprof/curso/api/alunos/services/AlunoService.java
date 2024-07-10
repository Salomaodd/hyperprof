package com.hyperprof.curso.api.alunos.services;

import com.hyperprof.curso.api.alunos.dtos.AlunoRequest;
import com.hyperprof.curso.api.alunos.dtos.AlunoResponse;

public interface AlunoService {

    AlunoResponse cadastrarAluno(AlunoRequest alunoRequest, Long professorId);
}
