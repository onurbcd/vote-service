package com.onurbcd.vote.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class AgendaResult implements Serializable {

    @Serial
    private static final long serialVersionUID = 2051543475812688444L;

    private String summary;

    private long totalNumberOfVotes;

    private long numberOfYesVotes;

    private long numberOfNoVotes;

    private String result;

    public AgendaResult(String summary, long totalNumberOfVotes, long numberOfYesVotes, long numberOfNoVotes) {
        this.summary = summary;
        this.totalNumberOfVotes = totalNumberOfVotes;
        this.numberOfYesVotes = numberOfYesVotes;
        this.numberOfNoVotes = numberOfNoVotes;
        result = numberOfYesVotes == numberOfNoVotes ? "EMPATE" : (numberOfYesVotes > numberOfNoVotes ? "SIM" : "NÃO");
    }
}
