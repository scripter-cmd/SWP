package com.example.shrinkwrap.model;


import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import com.example.shrinkwrap.JsonConverter;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sub_submission")
@Data
public class Submission {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "SUBMISSION_NUMBER", unique = true, nullable = false)
    private String SUBMISSION_NUMBER;

    @Column(name = "_DATA", columnDefinition = "json")
    @Convert(converter = JsonConverter.class)
    @JsonProperty("_DATA")  // Match JSON key exactly
    private Map<String, Object> data;

    @Column(name = "OWNER_ID")
    @JsonProperty("OWNER_ID")  // Match JSON key exactly
    private int ownerId;

    @Column(name = "ACTIVE")
    @JsonProperty("ACTIVE")  // Match JSON key exactly
    private String active;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.createdDate = LocalDateTime.now();
        this.SUBMISSION_NUMBER = "SN-" + System.currentTimeMillis();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}
