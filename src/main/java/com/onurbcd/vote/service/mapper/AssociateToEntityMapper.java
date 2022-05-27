package com.onurbcd.vote.service.mapper;

import com.onurbcd.vote.dto.AssociateDto;
import com.onurbcd.vote.persistency.entity.Associate;
import org.mapstruct.Mapper;

import java.util.function.Function;

@Mapper(componentModel = "spring")
public interface AssociateToEntityMapper extends Function<AssociateDto, Associate> {

    @Override
    Associate apply(AssociateDto associateDto);
}
