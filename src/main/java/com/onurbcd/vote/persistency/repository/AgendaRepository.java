package com.onurbcd.vote.persistency.repository;

import com.onurbcd.vote.dto.AgendaResult;
import com.onurbcd.vote.persistency.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, UUID>, QuerydslPredicateExecutor<Agenda> {

    @Query("select new com.onurbcd.vote.dto.AgendaResult(a.summary, count(1)," +
            " sum(case v.result when true then 1 else 0 end), sum(case v.result when false then 1 else 0 end))" +
            " from Agenda a" +
            " join a.sessions s" +
            " join s.votes v" +
            " where a.id = :id" +
            " group by a.summary")
    AgendaResult getResult(@Param("id") UUID id);
}
