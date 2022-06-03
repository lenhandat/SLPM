package com.fpt.capstone.backend.api.BackEnd.service.validate;

import com.fpt.capstone.backend.api.BackEnd.dto.IterationsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.SubjectsDTO;
import com.fpt.capstone.backend.api.BackEnd.repository.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;



public class Validate {

    @Autowired
    private SubjectsRepository subjectsRepository;

    public boolean validate(String value, String regex) {
        return value.matches(regex);
    }
    public boolean validateSubject(SubjectsDTO subjects) throws Exception {

        if(!validate(subjects.getCode(),String.valueOf(ConstantsRegex.CODE_PATTERN))){
            throw new Exception("Subject Code must have 3-50 character and don't have special characters");
        }
        if (!validate(subjects.getName(), String.valueOf(ConstantsRegex.NAME_PATTERN))){
            throw new Exception("Subject name is not contain special characters");
        }
        if (!validate(subjects.getStatus(), String.valueOf(ConstantsRegex.STATUS_PATTERN))){
            throw new Exception("Subject status must be active or inactive");
        }
        else{
            return true;
        }
    }

    public boolean validateIterations(IterationsDTO iterationsDTO) throws Exception {
        if(subjectsRepository.findById(iterationsDTO.getSubjectId()).isEmpty()){
            throw new Exception("Subject ID is not contain special characters");
        }
        if (!validate(iterationsDTO.getName(), String.valueOf(ConstantsRegex.NAME_PATTERN))){
            throw new Exception("Iterations name is not contain special characters");
        }
        if (!validate(iterationsDTO.getDuration().toString(), String.valueOf(ConstantsRegex.NUMBER_PATTERN))){
            throw new Exception("Iterations duration must be integer");
        }
        if (!validate(iterationsDTO.getStatus(), String.valueOf(ConstantsRegex.STATUS_PATTERN))){
            throw new Exception("Iterations status must be active or inactive");
        }
        else{
            return true;
        }
    }


}
