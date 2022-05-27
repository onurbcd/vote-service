package com.onurbcd.vote.service.mapper;

import com.onurbcd.vote.dto.SessionDto;
import com.onurbcd.vote.persistency.entity.Session;
import org.mapstruct.Mapper;

import java.util.function.Function;

@Mapper(componentModel = "spring")
public interface SessionToEntityMapper extends Function<SessionDto, Session> {

    @Override
    Session apply(SessionDto sessionDto);
}
