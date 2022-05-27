package com.onurbcd.vote.persistency.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id", callSuper = false)
@EntityListeners(AuditingEntityListener.class)
public class Session {

    @Id
    @GeneratedValue(generator = "uuid")
    private UUID id;

    @ManyToOne
    @NotNull
    private Agenda agenda;

    @CreatedDate
    @NotNull
    private LocalDateTime start;

    /**
     * Duração da sessão de votação em uma pauta, em minutos.
     */
    @NotNull
    @Min(1)
    @Max(30)
    private Integer duration;

    @NotNull
    private Boolean opened;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "session")
    private List<Vote> votes = new ArrayList<>();

    public boolean isClosed() {
        var end = start.plusMinutes(duration);
        return end.isBefore(LocalDateTime.now());
    }
}
