package com.onurbcd.vote.service.mapper;

import com.onurbcd.vote.dto.AssociateDto;
import com.onurbcd.vote.persistency.entity.Associate;
import org.mapstruct.Mapper;

import java.util.function.Function;

@Mapper(componentModel = "spring")
public interface AssociateToDtoMapper extends Function<Associate, AssociateDto> {

    @Override
    AssociateDto apply(Associate associate);
}
