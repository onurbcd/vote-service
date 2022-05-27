package com.onurbcd.vote.service.impl;

import com.onurbcd.vote.dto.AssociateDto;
import com.onurbcd.vote.persistency.repository.AssociateRepository;
import com.onurbcd.vote.service.AssociateService;
import com.onurbcd.vote.service.mapper.AssociateToDtoMapper;
import com.onurbcd.vote.service.mapper.AssociateToEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AssociateServiceImpl implements AssociateService {

    private final AssociateRepository repository;

    private final AssociateToEntityMapper toEntityMapper;

    private final AssociateToDtoMapper toDtoMapper;

    @Autowired
    public AssociateServiceImpl(AssociateRepository repository, AssociateToEntityMapper toEntityMapper,
                                AssociateToDtoMapper toDtoMapper) {

        this.repository = repository;
        this.toEntityMapper = toEntityMapper;
        this.toDtoMapper = toDtoMapper;
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public AssociateDto create(AssociateDto associateDto) {
        var associate = toEntityMapper.apply(associateDto);
        associate = repository.save(associate);
        return toDtoMapper.apply(associate);
    }

    @Override
    public Page<AssociateDto> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(toDtoMapper);
    }
}
