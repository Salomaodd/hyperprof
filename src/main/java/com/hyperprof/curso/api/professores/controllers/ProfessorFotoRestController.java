package com.hyperprof.curso.api.professores.controllers;

import com.hyperprof.curso.api.common.dtos.MessageResponse;
import com.hyperprof.curso.api.common.routes.ApiRoutes;
import com.hyperprof.curso.api.professores.dtos.FotoRequest;
import com.hyperprof.curso.api.professores.services.ProfessorFotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfessorFotoRestController {

    private final ProfessorFotoService professorFotoService;

    @PostMapping(ApiRoutes.ATUALIZAR_FOTO_PROFESSOR_LOGADO)
    public MessageResponse atualizarFotoProfessorLogado(@ModelAttribute @Valid FotoRequest fotoRequest) {
        return professorFotoService.atualizarFotoProfessorLogado(fotoRequest);
    }
}
