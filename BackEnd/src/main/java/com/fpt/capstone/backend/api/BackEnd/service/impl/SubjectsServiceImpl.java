package com.fpt.capstone.backend.api.BackEnd.service.impl;

import com.fpt.capstone.backend.api.BackEnd.dto.SubjectsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Subjects;
import com.fpt.capstone.backend.api.BackEnd.repository.SubjectsRepository;
import com.fpt.capstone.backend.api.BackEnd.service.SubjectsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectsServiceImpl implements SubjectsService {

    @Autowired
    private SubjectsRepository subjectsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SubjectsDTO addSubjects(SubjectsDTO subjectsDTO) {
        java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());
        subjectsDTO.setCreated(date);
        subjectsRepository.save(modelMapper.map(subjectsDTO, Subjects.class));
        return subjectsDTO;
    }

    @Override
    public void deleteSubjects(int id) {
        subjectsRepository.deleteById(id);
    }

    public SubjectsDTO findById(int id) {
        return modelMapper.map(subjectsRepository.findById(id), SubjectsDTO.class);
    }

    @Override
    public List<SubjectsDTO> showSubjectsList() {
        List<Subjects> subjects = subjectsRepository.findAll();
        List<SubjectsDTO> subjectsDTOS = subjects.stream()
                .map(subject -> modelMapper.map(subject, SubjectsDTO.class))
                .collect(Collectors.toList());
        return subjectsDTOS;
    }

    @Override
    public SubjectsDTO updateSubject(SubjectsDTO subjectsDTO) {
        java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());
        Subjects subjects = subjectsRepository.getOne(subjectsDTO.getId());

        subjects.setCode(subjectsDTO.getCode());
        subjects.setName(subjectsDTO.getName());
        subjects.setStatus(subjectsDTO.getStatus());
        subjects.setModified(date);
        subjects.setModifiedBy(subjectsDTO.getModifiedBy());

        subjectsRepository.save(subjects);
        subjectsDTO.setModified(date);
        return subjectsDTO;
    }

    @Override
    public Page<Subjects> listBy(String code, String name, String status, int page, int per_page) {
        Pageable pageable = PageRequest.of(page - 1, per_page);
        Page<Subjects> subjects = subjectsRepository.search(code, name, status, pageable);
        return subjects;
    }
}
