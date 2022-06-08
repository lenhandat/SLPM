package com.fpt.capstone.backend.api.BackEnd.repository;

import com.fpt.capstone.backend.api.BackEnd.dto.SubjectsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Subjects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Integer> {
    @Query(" SELECT new com.fpt.capstone.backend.api.BackEnd.dto.SubjectsDTO(s.id,s.code,s.name,s.status,s.created," +
            " s.created_by,s.modified,s.modified_by,u1.username,u2.username) FROM Subjects s "
            + " join Users u1 on u1.id=s.created_by "
            + " join Users u2 on u2.id=s.modified_by "
            + " WHERE s.code LIKE %:code%"
            + " and s.name LIKE %:name% and s.status LIKE %:status%")
    public Page<SubjectsDTO> search(@Param("code") String code, @Param("name") String name, @Param("status") String status, Pageable pageable);

    @Query("SELECT count(p.id) FROM Subjects p WHERE p.name like ?1 ")
    Integer findBySubjectName(String keyName);
}
