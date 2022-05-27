package com.onurbcd.vote.service;

import com.onurbcd.vote.dto.SessionDto;
import com.onurbcd.vote.persistency.entity.Session;
import org.springframework.lang.Nullable;

import java.util.UUID;

public interface SessionService {

    SessionDto create(SessionDto sessionDto);

    @Nullable
    Session findById(UUID id);
}
