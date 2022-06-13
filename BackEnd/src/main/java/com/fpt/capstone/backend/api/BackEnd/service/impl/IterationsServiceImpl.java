package com.fpt.capstone.backend.api.BackEnd.service.impl;

import com.fpt.capstone.backend.api.BackEnd.dto.IterationsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Iterations;
import com.fpt.capstone.backend.api.BackEnd.repository.IterationsRepository;
import com.fpt.capstone.backend.api.BackEnd.repository.SubjectsRepository;
import com.fpt.capstone.backend.api.BackEnd.service.ConstantsStatus;
import com.fpt.capstone.backend.api.BackEnd.service.InterationsService;
import com.fpt.capstone.backend.api.BackEnd.service.validate.Validate;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private Validate validate = new Validate();

    @Override
    public IterationsDTO addIterations(IterationsDTO iterationsDTO) throws Exception {
        validate.validateIterations(iterationsDTO);

        Iterations iterations = modelMapper.map(iterationsDTO, Iterations.class);
        iterations.setSubject(subjectsRepository.getById(iterationsDTO.getSubjectId()));
        iterationsRepository.save(iterations);
        return iterationsDTO;
    }

    @Override
    public void deleteIterations(int id) {
        Iterations iterations = iterationsRepository.getOne(id);
        iterations.setStatus(ConstantsStatus.inactive.toString());
        iterationsRepository.save(iterations);
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
    public void updateIterations(IterationsDTO iterationsDTO) throws Exception {

        validate.validateIterations(iterationsDTO);

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
    public Page<IterationsDTO> listBy(String name, int page, int per_page) throws Exception {
        Pageable pageable = PageRequest.of(page - 1, per_page);
        Page<IterationsDTO> iterations = iterationsRepository.search(name, pageable);
        return iterations;
    }

    public List<IterationsDTO> showIterationList() {
        List<Iterations> iterations = iterationsRepository.findAll();
        List<IterationsDTO> iterationsDTOS = iterations.stream()
                .map(iterations1 -> modelMapper.map(iterations1, IterationsDTO.class))
                .collect(Collectors.toList());

        return iterationsDTOS;
    }
}
