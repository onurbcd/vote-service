package com.onurbcd.vote.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class VoteDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5257450019926381958L;

    private UUID id;

    private LocalDateTime timestamp;

    private SessionDto session;

    private AssociateDto associate;

    private Boolean result;
}
