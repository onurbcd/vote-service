package com.onurbcd.vote.persistency.repository;

import com.onurbcd.vote.persistency.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SessionRepository extends JpaRepository<Session, UUID>, QuerydslPredicateExecutor<Session> {

    @Modifying
    @Query("update Session s set s.opened = false where s.id = :id")
    void closeSession(@Param("id") UUID id);
}
