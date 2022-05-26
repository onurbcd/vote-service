package com.onurbcd.vote.persistency.repository;

import com.onurbcd.vote.persistency.entity.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AssociateRepository extends JpaRepository<Associate, UUID>, QuerydslPredicateExecutor<Associate> {
}
