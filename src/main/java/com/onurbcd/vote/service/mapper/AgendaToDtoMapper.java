package com.onurbcd.vote.service.mapper;

import com.onurbcd.vote.dto.AgendaDto;
import com.onurbcd.vote.persistency.entity.Agenda;
import org.mapstruct.Mapper;

import java.util.function.Function;

@Mapper(componentModel = "spring")
public interface AgendaToDtoMapper extends Function<Agenda, AgendaDto> {

    @Override
    AgendaDto apply(Agenda agenda);
}
