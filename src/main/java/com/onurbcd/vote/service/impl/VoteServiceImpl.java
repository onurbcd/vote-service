package com.onurbcd.vote.service.impl;

import com.onurbcd.vote.dto.VoteDto;
import com.onurbcd.vote.persistency.repository.VoteRepository;
import com.onurbcd.vote.service.VoteService;
import com.onurbcd.vote.service.mapper.VoteToDtoMapper;
import com.onurbcd.vote.service.mapper.VoteToEntityMapper;
import com.onurbcd.vote.service.validation.VoteValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository repository;

    private final VoteValidationService validationService;

    private final VoteToEntityMapper toEntityMapper;

    private final VoteToDtoMapper toDtoMapper;

    @Autowired
    public VoteServiceImpl(VoteRepository repository, VoteValidationService validationService,
                           VoteToEntityMapper toEntityMapper, VoteToDtoMapper toDtoMapper) {

        this.repository = repository;
        this.validationService = validationService;
        this.toEntityMapper = toEntityMapper;
        this.toDtoMapper = toDtoMapper;
    }

    @Override
    public VoteDto create(VoteDto voteDto) {
        validationService.validate(voteDto);
        var vote = toEntityMapper.apply(voteDto);
        vote = repository.save(vote);
        return toDtoMapper.apply(vote);
    }
}
