package com.onurbcd.vote.persistency.repository;

import com.onurbcd.vote.persistency.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, UUID>, QuerydslPredicateExecutor<Agenda> {
}
