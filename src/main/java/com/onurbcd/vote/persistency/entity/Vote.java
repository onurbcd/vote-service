package com.onurbcd.vote.persistency.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id", callSuper = false)
@EntityListeners(AuditingEntityListener.class)
public class Vote {

    @Id
    @GeneratedValue(generator = "uuid")
    private UUID id;

    @CreatedDate
    @NotNull
    private LocalDateTime timestamp;

    @ManyToOne
    @NotNull
    private Session session;

    @ManyToOne
    @NotNull
    private Associate associate;

    /**
     * Resultado da votação. true representa 'Sim', false representa 'Não'.
     */
    @NotNull
    private Boolean result;
}
