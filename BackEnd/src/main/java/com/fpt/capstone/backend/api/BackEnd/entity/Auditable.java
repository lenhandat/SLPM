package com.fpt.capstone.backend.api.BackEnd.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract  class Auditable {

    @CreatedBy
    @Column( name = "created_by",updatable = false)
    protected Integer createdBy;

    @CreatedDate
    @Column(name = "created", updatable = false)
    protected java.sql.Timestamp  created;

    @LastModifiedBy
    @Column(name = "modified_by")
    protected Integer modifiedBy;

    @LastModifiedDate
    @Column(name = "modified")
    protected java.sql.Timestamp  modified;


}
