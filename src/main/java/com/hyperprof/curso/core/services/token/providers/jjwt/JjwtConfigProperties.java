package com.hyperprof.curso.core.services.token.providers.jjwt;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class JjwtConfigProperties {

    @Value("accessTokenSigningKey")
    private String accessTokenSigningKey;

    private Long accessTokenExpiration = 600L;

    @Value("refreshTokenSigningKey")
    private String refreshTokenSigningKey;

    private Long refreshTokenExpiration = 1200L;

}
