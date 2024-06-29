package com.hyperprof.curso.api.professores.controllers;

import com.hyperprof.curso.api.professores.dtos.ProfessorResponse;
import com.hyperprof.curso.api.professores.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProfessorRestController {

    private final ProfessorService professorService;

    @GetMapping("/api/professores")
    public List<ProfessorResponse> buscarProfessores(@RequestParam(name = "q", required = false, defaultValue = "") String descricao) {
        return professorService.buscarProfessores(descricao);
    }
}
