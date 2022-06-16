package com.fpt.capstone.backend.api.BackEnd.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subjects")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Subjects extends Auditable  implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "status")
    private String status;


}
