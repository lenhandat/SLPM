package com.fpt.capstone.backend.api.BackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "settings")
@Data
public class Settings extends Auditable  implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "title")
    private String title;

    @Column(name = "value")
    private String value;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(name = "status")
    private String status;


//    @CreatedDate
//    @Column(name = "created")
//    private java.sql.Timestamp created;
//
//    @ManyToOne
//    @JoinColumn(name = "created_by")
//    @CreatedBy
//    @JsonBackReference
//    private Users createdBy;
//
//    @LastModifiedDate
//    @Column(name = "modified")
//    private java.sql.Timestamp modified;
//
//    @ManyToOne
//    @JoinColumn(name = "modified_by")
//    @LastModifiedBy
//    @JsonBackReference
//    private Users modifiedBy;

    //@OneToMany(mappedBy = "settings", cascade = CascadeType.ALL)
    // Quan hệ 1-n với đối tượng ở dưới (setting) (1 seting role có nhiều người )
    // MapopedBy trỏ tới tên biến settings ở trong Users.
    //    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    //    @ToString.Exclude // Khoonhg sử dụng trong toString()
    //    @JsonManagedReference
    //    private Collection<Users> Users;

}
