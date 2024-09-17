package com.hyperprof.curso.api.professores.controllers;

import com.hyperprof.curso.api.common.routes.ApiRoutes;
import com.hyperprof.curso.api.professores.dtos.ProfessorRequest;
import com.hyperprof.curso.api.professores.dtos.ProfessorResponse;
import com.hyperprof.curso.api.professores.services.ProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProfessorRestController {

    private final ProfessorService professorService;

    @GetMapping(ApiRoutes.BUSCAR_PROFESSORES)
    public List<ProfessorResponse> buscarProfessores(@RequestParam(name = "q", required = false, defaultValue = "") String descricao) {
        return professorService.buscarProfessores(descricao);
    }

    @GetMapping(ApiRoutes.BUSCAR_PROFESSOR_POR_ID)
    ProfessorResponse buscarProfessorPorId(@PathVariable Long professorId) {
        return professorService.buscarProfessorPorId(professorId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(ApiRoutes.CADASTRAR_PROFESSOR)
    public ProfessorResponse cadastrarProfessor(@RequestBody @Valid ProfessorRequest professorRequest) {
        return professorService.cadastrarProfessor(professorRequest);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping(ApiRoutes.ATUALIZAR_PROFESSOR_LOGADO)
    public ProfessorResponse atualizarProfessor(@RequestBody @Valid ProfessorRequest professorRequest) {
        return professorService.atualizarProfessor(professorRequest);
    }
}
