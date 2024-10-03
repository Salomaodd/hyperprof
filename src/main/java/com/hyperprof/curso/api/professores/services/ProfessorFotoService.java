package com.hyperprof.curso.api.professores.services;

import com.hyperprof.curso.api.common.dtos.MessageResponse;
import com.hyperprof.curso.api.professores.dtos.FotoRequest;

public interface ProfessorFotoService {

    MessageResponse atualizarFotoProfessorLogado(FotoRequest fotoRequest);

}
