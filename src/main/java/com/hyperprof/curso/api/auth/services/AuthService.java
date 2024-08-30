package com.hyperprof.curso.api.auth.services;

import com.hyperprof.curso.api.auth.dtos.LoginRequest;
import com.hyperprof.curso.api.auth.dtos.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
}
