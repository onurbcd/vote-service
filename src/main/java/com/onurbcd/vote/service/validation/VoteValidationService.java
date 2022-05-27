package com.onurbcd.vote.service.validation;

import com.onurbcd.vote.dto.VoteDto;

public interface VoteValidationService {

    void validate(VoteDto voteDto);
}
