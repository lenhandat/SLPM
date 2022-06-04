package com.fpt.capstone.backend.api.BackEnd.service;

import com.fpt.capstone.backend.api.BackEnd.dto.SubjectsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Subjects;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SubjectsService {
    SubjectsDTO addSubjects(SubjectsDTO subjectsDTO) throws Exception;

    void deleteSubjects(int id);

    List<SubjectsDTO> showSubjectsList();
    void updateSubject(SubjectsDTO subjectsDTO) throws Exception;

    SubjectsDTO findById(int id);
    Page<Subjects> listBy(String code, String name, String status,int page, int per_page ) throws Exception;
}
