package com.hyperprof.curso.api.professores.services;

import com.hyperprof.curso.api.common.dtos.MessageResponse;
import com.hyperprof.curso.api.professores.dtos.FotoRequest;
import com.hyperprof.curso.core.models.AuthenticatedUser;
import com.hyperprof.curso.core.repositories.ProfessorRepository;
import com.hyperprof.curso.core.services.storage.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfessorFotoServiceImpl implements ProfessorFotoService {

    private final StorageService storageService;
    private final ProfessorRepository professorRepository;

    @Override
    public MessageResponse atualizarFotoProfessorLogado(FotoRequest fotoRequest) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var professor = ((AuthenticatedUser) authentication.getPrincipal()).getProfessor();
        var foto = storageService.upload(fotoRequest.getFoto());
        professor.setFotoPerfil(foto);
        professorRepository.save(professor);
        return MessageResponse.builder()
                .message("Foto atualizada com sucesso")
                .build();
    }
}
