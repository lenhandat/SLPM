package com.fpt.capstone.backend.api.BackEnd.repository;

import com.fpt.capstone.backend.api.BackEnd.dto.SubjectsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.SubjectsListDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Subjects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Repository
public interface SubjectsRepository  extends JpaRepository<Subjects, Integer> {
    @Query(" SELECT new com.fpt.capstone.backend.api.BackEnd.dto.SubjectsListDTO(s.id,s.name)" +
            "  FROM Subjects s where s.status='active'")
    public List<SubjectsListDTO> search();

    @Query("SELECT count(p.id) FROM Subjects p WHERE p.name like ?1 ")
    Integer findBySubjectName(String keyName);

}
