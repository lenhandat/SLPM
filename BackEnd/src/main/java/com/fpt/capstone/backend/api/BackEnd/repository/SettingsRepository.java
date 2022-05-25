package com.fpt.capstone.backend.api.BackEnd.repository;

import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Integer> {
    @Query("SELECT p FROM Settings p WHERE p.title LIKE %?1%"
            + " OR p.value LIKE %?1%"
            + " OR p.title LIKE %?1%")
    public List<Settings> search(String keyword);
}
