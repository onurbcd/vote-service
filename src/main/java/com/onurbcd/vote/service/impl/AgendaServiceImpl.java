package com.onurbcd.vote.service.impl;

import com.onurbcd.vote.dto.AgendaDto;
import com.onurbcd.vote.persistency.repository.AgendaRepository;
import com.onurbcd.vote.service.AgendaService;
import com.onurbcd.vote.service.mapper.AgendaToDtoMapper;
import com.onurbcd.vote.service.mapper.AgendaToEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository repository;

    private final AgendaToEntityMapper toEntityMapper;

    private final AgendaToDtoMapper toDtoMapper;

    @Autowired
    public AgendaServiceImpl(AgendaRepository repository, AgendaToEntityMapper toEntityMapper,
                             AgendaToDtoMapper toDtoMapper) {

        this.repository = repository;
        this.toEntityMapper = toEntityMapper;
        this.toDtoMapper = toDtoMapper;
    }

    @Override
    public AgendaDto create(AgendaDto agendaDto) {
        var agenda = toEntityMapper.apply(agendaDto);
        agenda = repository.save(agenda);
        return toDtoMapper.apply(agenda);
    }

    @Override
    public Page<AgendaDto> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(toDtoMapper);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }
}
