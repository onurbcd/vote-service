package com.onurbcd.vote.persistency.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Pauta de uma assembleia de votação.
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id", callSuper = false)
public class Agenda {

    /**
     * Identificador único da pauta.
     */
    @Id
    @GeneratedValue(generator = "uuid")
    private UUID id;

    /**
     * Sumário ou descriçao da pauta.
     */
    @NotNull
    @Size(min = 50, max = 1000)
    private String summary;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agenda")
    private List<Session> sessions = new ArrayList<>();
}
