package com.carvalho.ironcalc.model.bd.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractBaseEntity {

    private static final String DEFAULT_AUDITOR = "API";

    @JsonIgnore
    @CreatedDate
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    @JsonIgnore
    @CreatedBy
    @Column(name = "CREATED_BY", nullable = false, updatable = false, length = 50)
    private String createdBy = DEFAULT_AUDITOR;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "UPDATED_AT")
    private Instant updatedAt;

    @JsonIgnore
    @LastModifiedBy
    @Column(name = "UPDATED_BY", length = 50)
    private String updatedBy = DEFAULT_AUDITOR;

    @JsonIgnore
    @Version
    @Column(name = "VERSION", nullable = false)
    private Integer version = 0;
}