package com.hyperprof.curso.api.auth.controllers;

import com.hyperprof.curso.api.auth.dtos.LoginRequest;
import com.hyperprof.curso.api.auth.dtos.LoginResponse;
import com.hyperprof.curso.api.auth.dtos.RefreshRequest;
import com.hyperprof.curso.api.auth.services.AuthService;
import com.hyperprof.curso.api.common.routes.ApiRoutes;
import com.hyperprof.curso.api.common.utils.JwtBearerDefaults;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthRestController {

    private final AuthService authService;

    @PostMapping(ApiRoutes.LOGIN)
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping(ApiRoutes.REFRESH)
    public LoginResponse refresh(@RequestBody @Valid RefreshRequest refreshRequest) {
        return authService.refresh(refreshRequest);
    }

    @PostMapping(ApiRoutes.LOGOUT)
    @PreAuthorize(value = "isAuthenticated()")
    public void logout(@RequestHeader String authorization, @RequestBody @Valid RefreshRequest refreshRequest) {
        var token = authorization.substring(JwtBearerDefaults.TOKEN_TYPE.length());
        authService.logout(token, refreshRequest);
    }
}
