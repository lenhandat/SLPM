package com.fpt.capstone.backend.api.BackEnd.repository;

import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Integer> {

    @Query("SELECT new com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO(p.id,p.typeId,p.title,p.value,p.displayOrder" +
            ",p.status,p.created,p.created_by,p.modified,p.modified_by,u1.username,u2.username)  FROM Settings p " +
            "join Users u1 on u1.id=p.created_by " +
            "join Users u2 on u2.id=p.modified_by " +
            " WHERE p.title LIKE %:keyTitle% "
            +" and p.value LIKE %:keyValue% "
            +" order by p.typeId"
    )
     Page<SettingsDTO> search(@Param("keyTitle") String keyTitle, @Param("keyValue") String keyValue, Pageable pageable);

    @Query("SELECT count(p.id) FROM Settings p WHERE p.title LIKE %:keyTitle%"
            + " and p.value LIKE %:keyValue%")
     Integer getTotalSetting(@Param("keyTitle") String keyTitle, @Param("keyValue") String keyValue);


    @Query("SELECT count(p.id) FROM Settings p WHERE p.typeId = ?1"
            + " and p.displayOrder = ?2")
    Integer searchByTypeIdDisplayOrder(int typeId,int displayOrder);
}
