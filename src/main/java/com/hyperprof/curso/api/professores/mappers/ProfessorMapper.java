package com.hyperprof.curso.api.professores.mappers;

import com.hyperprof.curso.api.professores.dtos.ProfessorRequest;
import com.hyperprof.curso.api.professores.dtos.ProfessorResponse;
import com.hyperprof.curso.core.models.Professor;

public interface ProfessorMapper {

    Professor toProfessor(ProfessorRequest professorRequest);
    ProfessorResponse toProfessorResponse(Professor professor);
}
