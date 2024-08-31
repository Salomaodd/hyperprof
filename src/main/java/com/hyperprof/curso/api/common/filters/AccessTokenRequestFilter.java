package com.hyperprof.curso.api.common.filters;

import com.hyperprof.curso.api.common.utils.JwtBearerDefaults;
import com.hyperprof.curso.core.services.token.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AccessTokenRequestFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        var token = "";
        var email = "";
        var authorizationHeader = request.getHeader("Authorization");
        if (isTokenPresent(authorizationHeader)) {
            token = authorizationHeader.substring(JwtBearerDefaults.TOKEN_TYPE.length());
            email = tokenService.getSubjectDoAccessToken(token);
        }
        if (isEmailNotInContext(email)) {
            setAuthentication(request, email);
        }
        filterChain.doFilter(request, response);
    }

    private void setAuthentication(HttpServletRequest request, String email) {
        var userDetails = userDetailsService.loadUserByUsername(email);
        var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private boolean isEmailNotInContext(String email) {
        return email != null && !email.isEmpty() && SecurityContextHolder.getContext().getAuthentication() == null;
    }

    private boolean isTokenPresent(String authorizationHeader) {
        return authorizationHeader != null && authorizationHeader.startsWith(JwtBearerDefaults.TOKEN_TYPE);
    }

}
