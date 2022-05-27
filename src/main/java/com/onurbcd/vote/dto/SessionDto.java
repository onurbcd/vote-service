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
public class SessionDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 4419672960440320284L;

    private UUID id;

    private AgendaDto agenda;

    private LocalDateTime start;

    private Integer duration;

    private Boolean opened;
}
