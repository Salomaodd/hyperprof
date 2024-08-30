package com.hyperprof.curso.api.auth.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @Email
    @NotEmpty
    @NotNull
    @Size(min = 3, max = 255)
    private String email;

    @NotEmpty
    @NotNull
    @Size(min = 6, max = 255)
    private String password;
}
