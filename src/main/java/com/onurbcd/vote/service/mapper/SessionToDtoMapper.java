package com.onurbcd.vote.service.mapper;

import com.onurbcd.vote.dto.SessionDto;
import com.onurbcd.vote.persistency.entity.Session;
import org.mapstruct.Mapper;

import java.util.function.Function;

@Mapper(componentModel = "spring")
public interface SessionToDtoMapper extends Function<Session, SessionDto> {

    @Override
    SessionDto apply(Session session);
}
