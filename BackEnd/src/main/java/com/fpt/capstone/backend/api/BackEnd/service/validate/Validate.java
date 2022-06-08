package com.fpt.capstone.backend.api.BackEnd.service.validate;

import com.fpt.capstone.backend.api.BackEnd.dto.IterationsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.SubjectsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.UserDTO;
import com.fpt.capstone.backend.api.BackEnd.repository.SubjectsRepository;
import com.fpt.capstone.backend.api.BackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Validate {

    @Autowired
    private SubjectsRepository subjectsRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean validate(String value, String regex) {
        return value.matches(regex);
    }

    public void validateSubject(SubjectsDTO subjects) throws Exception {

        if (!validate(subjects.getCode(), String.valueOf(ConstantsRegex.CODE_PATTERN))) {
            throw new Exception("Subject Code must have 3-50 character and don't have special characters");
        }
        if (!validate(subjects.getName(), String.valueOf(ConstantsRegex.NAME_PATTERN))) {
            throw new Exception("Subject name is not contain special characters");
        }
        if (!validate(subjects.getStatus(), String.valueOf(ConstantsRegex.STATUS_PATTERN))) {
            throw new Exception("Subject status must be active or inactive");
        }
    }

    public void validateIterations(IterationsDTO iterationsDTO) throws Exception {
//        if(subjectsRepository.findById(iterationsDTO.getSubjectId()).isEmpty()){
//            throw new Exception("Subject ID is not contain special characters");
//        }
        if (!validate(iterationsDTO.getName(), String.valueOf(ConstantsRegex.NAME_PATTERN))) {
            throw new Exception("Iterations name is not contain special characters");
        }
        if (!validate(iterationsDTO.getDuration().toString(), String.valueOf(ConstantsRegex.NUMBER_PATTERN))) {
            throw new Exception("Iterations duration must be integer");
        }
        if (!validate(iterationsDTO.getStatus(), String.valueOf(ConstantsRegex.STATUS_PATTERN))) {
            throw new Exception("Iterations status must be active or inactive");
        }

    }

    public void validateUsers(UserDTO userDTO) throws Exception {

        if (!validate(userDTO.getUsername(), String.valueOf(ConstantsRegex.USERNAME_PATTERN))) {
            throw new Exception("Username must have 5-20 character and not contain special characters");
        }
        if(userRepository.findByUsername(userDTO.getUsername())!=null){
            throw new Exception("Username is duplicate");
        }
        if (!validate(userDTO.getPassword(), String.valueOf(ConstantsRegex.PASSWORD_PATTERN))) {
            throw new Exception("Password must have 8-20 character," +
                    " must have uppercase, lowercase, number and special character ");
        }
        if (!validate(userDTO.getFullName(), String.valueOf(ConstantsRegex.FULLNAME_PATTERN))) {
            throw new Exception("Full name must not contain special character and number");
        }


    }


}
