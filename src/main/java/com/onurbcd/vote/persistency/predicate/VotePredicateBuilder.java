package com.onurbcd.vote.persistency.predicate;

import com.onurbcd.vote.persistency.entity.QVote;
import org.springframework.lang.Nullable;

import java.util.UUID;

public class VotePredicateBuilder extends BasePredicateBuilder {

    private VotePredicateBuilder() {
    }

    public static VotePredicateBuilder of() {
        return new VotePredicateBuilder();
    }

    public VotePredicateBuilder agendaId(@Nullable UUID agendaId) {
        if (agendaId != null) {
            builder().and(QVote.vote.session.agenda.id.eq(agendaId));
        }

        return this;
    }

    public VotePredicateBuilder associateId(@Nullable UUID associateId) {
        if (associateId != null) {
            builder().and(QVote.vote.associate.id.eq(associateId));
        }

        return this;
    }
}
