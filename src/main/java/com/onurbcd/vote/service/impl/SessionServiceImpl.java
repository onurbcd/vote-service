package com.onurbcd.vote.service.impl;

import com.onurbcd.vote.dto.SessionDto;
import com.onurbcd.vote.persistency.entity.Session;
import com.onurbcd.vote.persistency.predicate.SessionPredicateBuilder;
import com.onurbcd.vote.persistency.repository.SessionRepository;
import com.onurbcd.vote.property.VoteProperties;
import com.onurbcd.vote.service.SessionService;
import com.onurbcd.vote.service.mapper.SessionToDtoMapper;
import com.onurbcd.vote.service.mapper.SessionToEntityMapper;
import com.onurbcd.vote.service.validation.SessionValidationService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository repository;

    private final SessionValidationService validationService;

    private final SessionToEntityMapper toEntityMapper;

    private final SessionToDtoMapper toDtoMapper;

    private final VoteProperties config;

    @Autowired
    public SessionServiceImpl(SessionRepository repository, SessionValidationService validationService,
                              SessionToEntityMapper toEntityMapper, SessionToDtoMapper toDtoMapper,
                              VoteProperties config) {

        this.repository = repository;
        this.validationService = validationService;
        this.toEntityMapper = toEntityMapper;
        this.toDtoMapper = toDtoMapper;
        this.config = config;
    }

    @Transactional
    @Override
    public SessionDto create(SessionDto sessionDto) {
        validationService.validate(sessionDto);
        close(sessionDto.getAgenda().getId());
        var session = toEntityMapper.apply(sessionDto);
        session.setOpened(Boolean.TRUE);

        if (session.getDuration() == null) {
            session.setDuration(config.getMinSessionDuration());
        }

        session = repository.save(session);
        return toDtoMapper.apply(session);
    }

    @Override
    @Nullable
    public Session findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    private void close(UUID agendaId) {
        Predicate predicate = SessionPredicateBuilder.of().agendaId(agendaId).opened(Boolean.TRUE).build();
        repository.findOne(predicate).ifPresent(session -> repository.closeSession(session.getId()));
    }
}
