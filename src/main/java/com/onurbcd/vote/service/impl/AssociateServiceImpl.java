package com.onurbcd.vote.service.impl;

import com.onurbcd.vote.persistency.repository.AssociateRepository;
import com.onurbcd.vote.service.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AssociateServiceImpl implements AssociateService {

    private final AssociateRepository repository;

    @Autowired
    public AssociateServiceImpl(AssociateRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }
}
