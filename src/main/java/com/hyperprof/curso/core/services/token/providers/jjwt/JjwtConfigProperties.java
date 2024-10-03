package com.hyperprof.curso.core.services.token.providers.jjwt;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class JjwtConfigProperties {

    private String accessTokenSigningKey = "adb1a1e9a2ce48a003e59c35ca8c62331ed72f2cb0371b5ed3a4be1c6b563aa01e019ce89e76437f6d3912b17dd70d65e74fa415ccab97ca0072cf4857d9318a";
    private Long accessTokenExpiration = 6000L;

    private String refreshTokenSigningKey = "30fc30cb8edfb20740bc2abb3ed983268ddb85c33725658fc6ae7e681d4c3868ed26083b1519b7960f3bc467d336727af8495ae4f58ddf2fd0f70e272495a6d6";
    private Long refreshTokenExpiration = 12000L;

}
