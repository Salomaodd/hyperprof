package com.hyperprof.curso.api.professores.services;

import com.hyperprof.curso.api.professores.dtos.ProfessorRequest;
import com.hyperprof.curso.api.professores.dtos.ProfessorResponse;
import com.hyperprof.curso.api.professores.mappers.ProfessorMapper;
import com.hyperprof.curso.core.exceptions.ProfessorNotFoundException;
import com.hyperprof.curso.core.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfessorServiceImpl implements ProfessorService{

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<ProfessorResponse> buscarProfessores(String descricao) {
        return professorRepository.findByDescricao(descricao)
                .stream()
                .map(professorMapper::toProfessorResponse)
                .toList();
    }

    @Override
    public ProfessorResponse buscarProfessorPorId(Long professorId) {
        return professorRepository.findById(professorId)
                .map(professorMapper::toProfessorResponse)
                .orElseThrow(ProfessorNotFoundException::new);
    }

    @Override
    @Transactional
    public ProfessorResponse cadastrarProfessor(ProfessorRequest professorRequest) {
        if (!professorRequest.getPassword().equals(professorRequest.getPasswordConfirmation()))
            throw new RuntimeException("A confirmação de senha está diferente da semha");
        var professorParaCadastrar = professorMapper.toProfessor(professorRequest);
        professorParaCadastrar.setPassword(passwordEncoder.encode(professorParaCadastrar.getPassword()));
        var professorCadastrado = professorRepository.save(professorParaCadastrar);
        return professorMapper.toProfessorResponse(professorCadastrado);
    }
}
