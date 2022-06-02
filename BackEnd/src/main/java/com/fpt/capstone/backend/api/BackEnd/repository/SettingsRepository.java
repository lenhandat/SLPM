package com.fpt.capstone.backend.api.BackEnd.repository;

import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Integer> {

    @Query("SELECT p FROM Settings p " +
            " WHERE p.title LIKE %:keyTitle%"
            + " and p.value LIKE %:keyValue%"
            + " order by p.typeId"
    )
    public Page<Settings> search(@Param("keyTitle") String keyTitle, @Param("keyValue")String keyValue, Pageable pageable);

    @Query("SELECT count(p) FROM Settings p WHERE p.title LIKE %:keyTitle%"
            + " and p.value LIKE %:keyValue%")
    public Integer getTotalSetting(@Param("keyTitle") String keyTitle, @Param("keyValue")String keyValue);


}
