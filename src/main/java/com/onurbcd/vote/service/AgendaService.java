package com.onurbcd.vote.service;

import com.onurbcd.vote.dto.AgendaDto;
import com.onurbcd.vote.dto.AgendaResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AgendaService {

    AgendaDto create(AgendaDto agendaDto);

    Page<AgendaDto> getAll(Pageable pageable);

    boolean existsById(UUID id);

    AgendaResult getResult(UUID id);
}
