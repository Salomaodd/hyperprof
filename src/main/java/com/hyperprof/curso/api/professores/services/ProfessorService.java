package com.hyperprof.curso.api.professores.services;

import com.hyperprof.curso.api.professores.dtos.ProfessorRequest;
import com.hyperprof.curso.api.professores.dtos.ProfessorResponse;

import java.util.List;

public interface ProfessorService {

    List<ProfessorResponse> buscarProfessores(String descricao);
    ProfessorResponse buscarProfessorPorId(Long professorId);
    ProfessorResponse cadastrarProfessor(ProfessorRequest professorRequest);
    ProfessorResponse atualizarProfessor(ProfessorRequest professorRequest);


}
