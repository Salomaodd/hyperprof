package com.hyperprof.curso.core.services.token.providers.jjwt;

import com.hyperprof.curso.core.models.TokenInvalido;
import com.hyperprof.curso.core.repositories.TokenInvalidoRepository;
import com.hyperprof.curso.core.services.token.TokenService;
import com.hyperprof.curso.core.services.token.TokenServiceException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class JjwtTokenService implements TokenService {

    private final JjwtConfigProperties jjwtConfigProperties;
    private final TokenInvalidoRepository tokenInvalidoRepository;

    @Override
    public String gerarAccessToken(String subject) {
        return gerarToken(subject,
                jjwtConfigProperties.getAccessTokenExpiration(),
                jjwtConfigProperties.getAccessTokenSigningKey());
    }

    @Override
    public String getSubjectDoAccessToken(String accessToken) {
        return getClaims(accessToken, jjwtConfigProperties.getAccessTokenSigningKey()).getSubject();
    }

    @Override
    public String gerarRefreshToken(String subject) {
        return gerarToken(subject,
                jjwtConfigProperties.getRefreshTokenExpiration(),
                jjwtConfigProperties.getRefreshTokenSigningKey());
    }

    @Override
    public String getSubjectDoRefreshToken(String refreshToken) {
        return getClaims(refreshToken, jjwtConfigProperties.getRefreshTokenSigningKey()).getSubject();
    }

    @Override
    public void invalidarToken(String... tokens) {
        var tokensInvalidos = Stream.of(tokens)
                .map(token -> TokenInvalido.builder().token(token).build())
                .toList();
        tokenInvalidoRepository.saveAll(tokensInvalidos);
    }

    private String gerarToken(String subject, Long expirationInSeconds, String signingKey) {
        var dataHoraAtual = Instant.now();
        var dataHoraExpiracao = dataHoraAtual.plusSeconds(expirationInSeconds);
        return Jwts.builder()
                .setClaims(new HashMap<String, Object>())
                .setSubject(subject)
                .setIssuedAt(Date.from(dataHoraAtual))
                .setExpiration(Date.from(dataHoraExpiracao))
                .signWith(Keys.hmacShaKeyFor(signingKey.getBytes()))
                .compact();
    }

    private Claims getClaims(String token, String signingKey) {
        try {
            return tryGetClaims(token, signingKey);
        } catch (JwtException e) {
            throw new TokenServiceException(e.getLocalizedMessage());
        }
    }

    private Claims tryGetClaims(String token, String signingKey) {
        if (tokenInvalidoRepository.existsByToken(token)) {
            throw new TokenServiceException("Token inválido");
        }
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(signingKey.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
