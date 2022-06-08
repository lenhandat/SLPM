package com.fpt.capstone.backend.api.BackEnd.repository;

import com.fpt.capstone.backend.api.BackEnd.dto.IterationsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Iterations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IterationsRepository extends JpaRepository<Iterations, Integer> {

    @Query("SELECT new com.fpt.capstone.backend.api.BackEnd.dto.IterationsDTO(p.id,p.subject.id,p.name,p.duration," +
            "p.status,p.created,p.created_by,p.modified,p.modified_by,u1.username,u2.username) FROM Iterations p   " +
            " join Users u1 on u1.id=p.created_by " +
            " join Users u2 on u2.id=p.modified_by " +
            "  WHERE p.name LIKE %:keyName%"
            + " order by p.subject.id"
    )
    public Page<IterationsDTO> search(@Param("keyName") String keyName, Pageable pageable);

    @Query("SELECT count(p.id) FROM Iterations p WHERE p.name like '?1' ")
    Integer findByIterationsName(String keyName);
}
