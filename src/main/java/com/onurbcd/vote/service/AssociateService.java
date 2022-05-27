package com.onurbcd.vote.service;

import com.onurbcd.vote.dto.AssociateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AssociateService {

    boolean existsById(UUID id);

    AssociateDto create(AssociateDto associateDto);

    Page<AssociateDto> getAll(Pageable pageable);
}
