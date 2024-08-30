package com.hyperprof.curso.api.auth.controllers;

import com.hyperprof.curso.api.auth.dtos.LoginRequest;
import com.hyperprof.curso.api.auth.dtos.LoginResponse;
import com.hyperprof.curso.api.auth.services.AuthService;
import com.hyperprof.curso.api.common.routes.ApiRoutes;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthRestController {

    private final AuthService authService;

    @PostMapping(ApiRoutes.LOGIN)
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
