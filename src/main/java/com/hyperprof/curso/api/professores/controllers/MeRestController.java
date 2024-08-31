package com.hyperprof.curso.api.professores.controllers;

import com.hyperprof.curso.api.common.routes.ApiRoutes;
import com.hyperprof.curso.api.professores.dtos.ProfessorResponse;
import com.hyperprof.curso.api.professores.services.MeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MeRestController {

    private final MeService meService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping(ApiRoutes.PROFESSOR_LOGADO)
    public ProfessorResponse buscarProfessorLogado() {
        return meService.buscarProfessorLogado();
    }
}
