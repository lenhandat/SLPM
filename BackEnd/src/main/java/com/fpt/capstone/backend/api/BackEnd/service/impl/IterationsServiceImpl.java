package com.fpt.capstone.backend.api.BackEnd.service.impl;

import com.fpt.capstone.backend.api.BackEnd.dto.IterationsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Iterations;
import com.fpt.capstone.backend.api.BackEnd.repository.IterationsRepository;
import com.fpt.capstone.backend.api.BackEnd.repository.SubjectsRepository;
import com.fpt.capstone.backend.api.BackEnd.service.InterationsService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IterationsServiceImpl implements InterationsService {

    @Autowired
    private IterationsRepository iterationsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SubjectsRepository subjectsRepository;

    @Override
    public IterationsDTO addIterations(IterationsDTO iterationsDTO) {
        java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());

        Iterations iterations = modelMapper.map(iterationsDTO, Iterations.class);
        iterations.setCreated(date);
        iterations.setSubject(subjectsRepository.getById(iterationsDTO.getSubjectId()));
        iterationsRepository.save(iterations);
        return iterationsDTO;
    }

    @Override
    public void deleteIterations(int id) {
        iterationsRepository.deleteById(id);
    }

    @Override
    public List<IterationsDTO> showIterationsList() {
        List<Iterations> iterations = iterationsRepository.findAll();
        List<IterationsDTO> iterationsDTOS = iterations.stream()
                .map(iteration -> modelMapper.map(iteration, IterationsDTO.class))
                .collect(Collectors.toList());
        return iterationsDTOS;
    }

    @Override
    public void updateIterations(IterationsDTO iterationsDTO) {
        Iterations iterations = iterationsRepository.getOne(iterationsDTO.getId());

        iterations.setSubject(subjectsRepository.getById(iterationsDTO.getSubjectId()));
        iterations.setName(iterationsDTO.getName());
        iterations.setDuration(iterationsDTO.getDuration());
        iterations.setStatus(iterationsDTO.getStatus());
        iterationsRepository.save(iterations);
    }

    @Override
    public IterationsDTO findById(int id) {
        return modelMapper.map(subjectsRepository.findById(id), IterationsDTO.class);
    }

    @Override
    public Page<Iterations> listBy(String name, int page, int per_page) {
        Pageable pageable= PageRequest.of(page-1,per_page);
        Page<Iterations> iterations = iterationsRepository.search(name,pageable);

        return iterations;
    }

    public List<IterationsDTO> showIterationList(){
        List<Iterations> iterations = iterationsRepository.findAll();
        List<IterationsDTO> iterationsDTOS = iterations.stream()
                .map(iterations1 -> modelMapper.map(iterations1 , IterationsDTO.class))
                .collect(Collectors.toList());

        return  iterationsDTOS;
    }
}
