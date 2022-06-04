package com.fpt.capstone.backend.api.BackEnd.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "subjects")
@Data
public class Subjects extends Auditable  implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

//    @OneToMany(mappedBy = "subject",cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private Collection<Iterations> iterations;
}
