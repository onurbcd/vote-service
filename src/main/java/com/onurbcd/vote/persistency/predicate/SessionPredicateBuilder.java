package com.onurbcd.vote.persistency.predicate;

import com.onurbcd.vote.persistency.entity.QSession;
import org.springframework.lang.Nullable;

import java.util.UUID;

public class SessionPredicateBuilder extends BasePredicateBuilder {

    private SessionPredicateBuilder() {
    }

    public static SessionPredicateBuilder of() {
        return new SessionPredicateBuilder();
    }

    public SessionPredicateBuilder agendaId(@Nullable UUID agendaId) {
        if (agendaId != null) {
            builder().and(QSession.session.agenda.id.eq(agendaId));
        }

        return this;
    }

    public SessionPredicateBuilder opened(@Nullable Boolean opened) {
        if (opened != null) {
            builder().and(QSession.session.opened.eq(opened));
        }

        return this;
    }
}
