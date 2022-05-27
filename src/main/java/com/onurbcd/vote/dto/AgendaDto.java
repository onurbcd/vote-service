package com.onurbcd.vote.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class AgendaDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5609110616372375362L;

    private UUID id;

    private String summary;
}
