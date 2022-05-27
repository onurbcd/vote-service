package com.onurbcd.vote.service.mapper;

import com.onurbcd.vote.dto.VoteDto;
import com.onurbcd.vote.persistency.entity.Vote;
import org.mapstruct.Mapper;

import java.util.function.Function;

@Mapper(componentModel = "spring")
public interface VoteToEntityMapper extends Function<VoteDto, Vote> {

    @Override
    Vote apply(VoteDto voteDto);
}
