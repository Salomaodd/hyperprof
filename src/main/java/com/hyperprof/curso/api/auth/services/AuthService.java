package com.hyperprof.curso.api.auth.services;

import com.hyperprof.curso.api.auth.dtos.LoginRequest;
import com.hyperprof.curso.api.auth.dtos.LoginResponse;
import com.hyperprof.curso.api.auth.dtos.RefreshRequest;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refresh(RefreshRequest refreshRequest);
}
