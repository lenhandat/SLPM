package com.fpt.capstone.backend.api.BackEnd.dto;


import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data

public class SettingsDTO implements Serializable {
    private Integer id;
    private Integer typeId;
    private String title;
    private String value;
    private Integer displayOrder;
    private String status;
    private java.sql.Timestamp created;
    private Integer created_by;
    private java.sql.Timestamp modified;
    private Integer modified_by;
    private String createdByUser;
    private String modifiedByUser;

    public SettingsDTO(Integer id, Integer typeId, String title, String value, Integer displayOrder, String status, Timestamp created, Integer created_by, Timestamp modified, Integer modified_by, String createdByUser, String modifiedByUser) {
        this.id = id;
        this.typeId = typeId;
        this.title = title;
        this.value = value;
        this.displayOrder = displayOrder;
        this.status = status;
        this.created = created;
        this.created_by = created_by;
        this.modified = modified;
        this.modified_by = modified_by;
        this.createdByUser = createdByUser;
        this.modifiedByUser = modifiedByUser;
    }
    public SettingsDTO() {
    }
}
