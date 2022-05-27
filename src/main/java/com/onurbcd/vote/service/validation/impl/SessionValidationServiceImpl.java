package com.onurbcd.vote.service.validation.impl;

import com.onurbcd.vote.dto.SessionDto;
import com.onurbcd.vote.persistency.predicate.SessionPredicateBuilder;
import com.onurbcd.vote.persistency.repository.SessionRepository;
import com.onurbcd.vote.service.AgendaService;
import com.onurbcd.vote.service.enums.Error;
import com.onurbcd.vote.service.validation.Action;
import com.onurbcd.vote.service.validation.SessionValidationService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionValidationServiceImpl implements SessionValidationService {

    private final AgendaService agendaService;

    private final SessionRepository repository;

    @Autowired
    public SessionValidationServiceImpl(AgendaService agendaService, SessionRepository repository) {
        this.agendaService = agendaService;
        this.repository = repository;
    }

    @Override
    public void validate(SessionDto sessionDto) {
        // validar se o id da pauta é nulo
        Action.checkIf(sessionDto.getAgenda() != null && sessionDto.getAgenda().getId() != null)
                .orElseThrow(Error.AGENDA_ID_IS_NULL);
        var agendaId = sessionDto.getAgenda().getId();
        // validar se a pauta existe
        Action.checkIf(agendaService.existsById(agendaId)).orElseThrowNotFound(Error.AGENDA_DOES_NOT_EXIST, agendaId);
        // validar se as sessões estão todas fechadas
        Action.checkIf(sessionClosed(agendaId)).orElseThrow(Error.SESSION_ALREADY_OPENED, agendaId);
    }

    private boolean sessionClosed(UUID agendaId) {
        Predicate predicate = SessionPredicateBuilder.of().agendaId(agendaId).opened(Boolean.TRUE).build();
        var session = repository.findOne(predicate).orElse(null);
        return session != null ? session.isClosed() : Boolean.TRUE;
    }
}
