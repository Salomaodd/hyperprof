package com.hyperprof.curso.core.services.token.providers.jjwt;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class JjwtConfigProperties {

    @Value("accessTokenSigningKey")
    private String accessTokenSigningKey;
    @Value("accessTokenExpiration")
    private Long accessTokenExpiration;
    @Value("refreshTokenSigningKey")
    private String refreshTokenSigningKey;
    @Value("refreshTokenExpiration")
    private Long refreshTokenExpiration;

}
