package com.onurbcd.vote.service.validation.impl;

import com.onurbcd.vote.dto.VoteDto;
import com.onurbcd.vote.persistency.entity.Session;
import com.onurbcd.vote.persistency.predicate.VotePredicateBuilder;
import com.onurbcd.vote.persistency.repository.VoteRepository;
import com.onurbcd.vote.service.AssociateService;
import com.onurbcd.vote.service.SessionService;
import com.onurbcd.vote.service.enums.Error;
import com.onurbcd.vote.service.validation.Action;
import com.onurbcd.vote.service.validation.VoteValidationService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteValidationServiceImpl implements VoteValidationService {

    private final SessionService sessionService;

    private final AssociateService associateService;

    private final VoteRepository repository;

    @Autowired
    public VoteValidationServiceImpl(SessionService sessionService, AssociateService associateService,
                                     VoteRepository repository) {

        this.sessionService = sessionService;
        this.associateService = associateService;
        this.repository = repository;
    }

    @Override
    public void validate(VoteDto voteDto) {
        // verificar se a sessão e o id da sessão não são nulos
        Action.checkIf(voteDto.getSession() != null && voteDto.getSession().getId() != null)
                .orElseThrow(Error.SESSION_ID_IS_NULL);
        // verificar se o associado e o id do associado não são nulos
        Action.checkIf(voteDto.getAssociate() != null && voteDto.getAssociate().getId() != null)
                .orElseThrow(Error.ASSOCIATE_ID_IS_NULL);
        // verificar se o resultado do voto não é nulo
        Action.checkIfNotNull(voteDto.getResult()).orElseThrow(Error.VOTE_RESULT_IS_NULL);
        // verificar se a sessão existe na base de dados
        var session = sessionService.findById(voteDto.getSession().getId());
        Action.checkIfNotNull(session).orElseThrowNotFound(Error.SESSION_DOES_NOT_EXIST, voteDto.getSession().getId());
        // verificar se a sessão ainda está aberta
        assert session != null;
        Action.checkIf(!session.isClosed()).orElseThrow(Error.SESSION_IS_CLOSED, voteDto.getSession().getId());
        // verificar se o associado existe na base de dados
        Action.checkIf(associateService.existsById(voteDto.getAssociate().getId()))
                .orElseThrowNotFound(Error.ASSOCIATE_DOES_NOT_EXIST, voteDto.getAssociate().getId());
        // verificar se o associado já votou na pauta
        Action.checkIf(haventVoted(voteDto, session))
                .orElseThrow(Error.ASSOCIATE_ALREADY_VOTED, voteDto.getAssociate().getId(), session.getAgenda().getId());
    }

    private boolean haventVoted(VoteDto voteDto, Session session) {
        Predicate predicate = VotePredicateBuilder.of().agendaId(session.getAgenda().getId())
                .associateId(voteDto.getAssociate().getId()).build();

        return !repository.exists(predicate);
    }
}
