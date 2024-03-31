package com.aircraft.aircraft_hold_property.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

public abstract class BaseEntity implements Serializable {

    @CreatedDate
    @Column(name = "CREATED_DATE" ,updatable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdDate;

    @CreatedBy
    @Column(name = "CREATED_BY" ,updatable = false)
    private Long createdBy;

    @LastModifiedDate
    @Column(name = "MODIFIED_DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime modifiedDate;

    @LastModifiedBy
    @Column(name = "MODIFIED_BY" ,updatable = false)
    private Long modifiedBy;

    @Column(name = "ACTIVE")
    private boolean active = true;

    @Column(name = "DELETED")
    private boolean deleted = false;



}
