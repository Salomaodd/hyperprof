package com.hyperprof.curso.core.services.token;

public interface TokenService {

    String gerarAccessToken(String subject);
    String getSubjectDoAccessToken(String accessToken);
    String gerarRefreshToken(String subject);
    String getSubjectDoRefreshToken(String refreshToken);
    void invalidarToken(String... tokens);

}
