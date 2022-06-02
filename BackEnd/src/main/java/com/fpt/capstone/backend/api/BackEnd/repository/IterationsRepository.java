package com.fpt.capstone.backend.api.BackEnd.repository;

import com.fpt.capstone.backend.api.BackEnd.entity.Iterations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IterationsRepository extends JpaRepository<Iterations, Integer> {

    @Query("SELECT p FROM Iterations p WHERE p.name LIKE %:keyName%"
            + " order by p.subject.id"
    )
    public Page<Iterations> search(@Param("keyName") String keyName, Pageable pageable);

}
