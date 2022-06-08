package com.fpt.capstone.backend.api.BackEnd.repository;

import com.fpt.capstone.backend.api.BackEnd.entity.Subjects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects,Integer> {
    @Query("SELECT s FROM Subjects s WHERE s.code LIKE %?1%"
            + " OR s.name LIKE %?2% OR s.status LIKE %?3%" )
    public Page<Subjects> search(String code, String name, String status, Pageable pageable);

    @Query("SELECT count(p.id) FROM Subjects p WHERE p.name like ?1 ")
    Integer findBySubjectName( String keyName);
}
