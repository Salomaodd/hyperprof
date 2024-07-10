package com.hyperprof.curso.api.alunos.services;

import com.hyperprof.curso.api.alunos.dtos.AlunoRequest;
import com.hyperprof.curso.api.alunos.dtos.AlunoResponse;
import com.hyperprof.curso.api.alunos.mappers.AlunoMapper;
import com.hyperprof.curso.core.exceptions.ProfessorNotFoundException;
import com.hyperprof.curso.core.repositories.AlunoRepository;
import com.hyperprof.curso.core.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService{

    private final AlunoMapper alunoMapper;
    private final AlunoRepository alunoRepository;
    private final ProfessorRepository professorRepository;

    @Override
    public AlunoResponse cadastrarAluno(AlunoRequest alunoRequest, Long professorId) {
        var professor = professorRepository.findById(professorId)
                .orElseThrow(ProfessorNotFoundException::new);
        var alunoParaCadastrar = alunoMapper.toAluno(alunoRequest);
        alunoParaCadastrar.setProfessor(professor);
        var alunoCadastrado = alunoRepository.save(alunoParaCadastrar);
        return alunoMapper.toAlunoResponse(alunoCadastrado);
    }
}
