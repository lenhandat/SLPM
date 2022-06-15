package com.fpt.capstone.backend.api.BackEnd.repository;

import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Repository
public interface SettingsRepository extends JpaRepository<Settings, Integer> {

//    @Query("SELECT new com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO(s1.id,s1.typeId,s1.title,s1.value,s1.displayOrder" +
//            ",s1.status,s1.created,s1.created_by,s1.modified,s1.modified_by,u1.email,u2.email)  FROM Settings s1 " +
//            "join Settings s2 ON s1.typeId = s2.id "+
//            "join Users u1 on u1.id=s1.created_by " +
//            "join Users u2 on u2.id=s1.modified_by " +
//            " WHERE s1.title LIKE %:keyTitle% "
//            + " and s1.value LIKE %:keyValue% "
//            + " order by s1.typeId"
//    )
//    Page<SettingsDTO> search(@Param("keyTitle") String keyTitle, @Param("keyValue") String keyValue, Pageable pageable);
//
//    @Query("SELECT count(p.id) FROM Settings p WHERE p.title LIKE %:keyTitle%"
//            + " and p.value LIKE %:keyValue%")
//    Integer getTotalSetting(@Param("keyTitle") String keyTitle, @Param("keyValue") String keyValue);

    Optional<Settings> findRoleByValue(String value);

        @Query("SELECT count(p.id) FROM Settings p WHERE p.typeId = ?1"
            + " and p.displayOrder = ?2")
    Integer searchByTypeIdDisplayOrder(int typeId, int displayOrder);

    @Query("SELECT s FROM Settings s WHERE s.typeId = 1")
    public List<Settings> getTypeSeting();

    @Query("SELECT new com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO( s1.id, s1.typeId, s2.value , s1.value" +
            ", s1.displayOrder, s1.status, s1.created, s1.created_by, s1.modified, s1.modified_by,u1.email,u2.email) " +
            "FROM Settings s1 " +
            "JOIN Settings s2 ON s1.typeId = s2.id " +
            "join Users u1 on u1.id=s1.created_by " +
            "join Users u2 on u2.id=s1.modified_by " +
            "WHERE s2.id = ?1 AND s1.value LIKE %?2% ")
    public Page<SettingsDTO> getSetingByType(int id,String value, Pageable pageable);

    @Modifying
    @Query("UPDATE Settings s SET s.status= 'inactive'  WHERE s.id=?1")
    void deleteSettingById (int id);
}
