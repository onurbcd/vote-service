package com.onurbcd.vote.service;

import com.onurbcd.vote.dto.SessionDto;
import com.onurbcd.vote.persistency.entity.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;

import java.util.UUID;

public interface SessionService {

    SessionDto create(SessionDto sessionDto);

    @Nullable
    Session findById(UUID id);

    Page<SessionDto> getAll(Pageable pageable);
}
