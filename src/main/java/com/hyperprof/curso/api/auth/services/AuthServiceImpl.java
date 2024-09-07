package com.hyperprof.curso.api.auth.services;

import com.hyperprof.curso.api.auth.dtos.LoginRequest;
import com.hyperprof.curso.api.auth.dtos.LoginResponse;
import com.hyperprof.curso.api.auth.dtos.RefreshRequest;
import com.hyperprof.curso.core.exceptions.ProfessorNotFoundException;
import com.hyperprof.curso.core.models.AuthenticatedUser;
import com.hyperprof.curso.core.repositories.ProfessorRepository;
import com.hyperprof.curso.core.services.token.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final ProfessorRepository professorRepository;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword());
        var authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        var professor = ((AuthenticatedUser) authentication.getPrincipal()).getProfessor();
        return LoginResponse.builder()
                .token(tokenService.gerarAccessToken(professor.getEmail()))
                .refreshToken(tokenService.gerarRefreshToken(professor.getEmail()))
                .build();
    }

    @Override
    public LoginResponse refresh(RefreshRequest refreshRequest) {
        var subject = tokenService.getSubjectDoRefreshToken(refreshRequest.getRefreshToken());
        if (!professorRepository.existsByEmail(subject)) {
            throw new ProfessorNotFoundException();
        }

        return LoginResponse.builder()
                .token(tokenService.gerarAccessToken(subject))
                .refreshToken(tokenService.gerarRefreshToken(subject))
                .build();
    }
}
