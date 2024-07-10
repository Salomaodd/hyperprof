package com.hyperprof.curso.api.alunos.controllers;

import com.hyperprof.curso.api.alunos.dtos.AlunoRequest;
import com.hyperprof.curso.api.alunos.dtos.AlunoResponse;
import com.hyperprof.curso.api.alunos.services.AlunoService;
import com.hyperprof.curso.api.common.routes.ApiRoutes;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AlunoRestController {

    private final AlunoService alunoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(ApiRoutes.CADASTRAR_ALUNO)
    public AlunoResponse cadastrarAluno(@RequestBody @Valid AlunoRequest alunoRequest,
                                        @PathVariable Long professorId) {
        return alunoService.cadastrarAluno(alunoRequest, professorId);
    }
}
