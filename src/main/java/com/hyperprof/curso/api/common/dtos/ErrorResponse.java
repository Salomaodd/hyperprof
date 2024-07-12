package com.hyperprof.curso.api.common.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ErrorResponse {

    private int status;
    private String message;
    private String error;
    private String cause;
    private LocalDateTime timestamp;

}
