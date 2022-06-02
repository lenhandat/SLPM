package com.fpt.capstone.backend.api.BackEnd.service;

import com.fpt.capstone.backend.api.BackEnd.dto.IterationsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Iterations;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InterationsService {
    IterationsDTO addIterations(IterationsDTO iterationsDTO);

    void deleteIterations(int id);

    List<IterationsDTO> showIterationsList();

    void updateIterations(IterationsDTO iterationsDTO);

    IterationsDTO findById(int id);

    Page<Iterations> listBy(String name, int page, int per_page);
}
