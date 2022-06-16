package com.fpt.capstone.backend.api.BackEnd.service.validate;

import com.fpt.capstone.backend.api.BackEnd.dto.IterationsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.SubjectsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.UsersDTO;
import com.fpt.capstone.backend.api.BackEnd.repository.IterationsRepository;
import com.fpt.capstone.backend.api.BackEnd.repository.SettingsRepository;
import com.fpt.capstone.backend.api.BackEnd.repository.SubjectsRepository;
import com.fpt.capstone.backend.api.BackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


@Service
public class Validate {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SettingsRepository settingsRepository;
    @Autowired
    private IterationsRepository iterationsRepository;
    @Autowired
    private SubjectsRepository subjectsRepository;

    public boolean validate(String value, String regex) {
        return value.matches(regex);
    }

    public void validateSubject(SubjectsDTO subjectsDTO) throws Exception {

//        if (subjectsRepository.findBySubjectName(subjectsDTO.getName()) > 0) {
//            throw new Exception("Subjects Name already exist ");
//        }
//        if (!validate(subjectsDTO.getCode(), String.valueOf(ConstantsRegex.CODE_PATTERN))) {
//            throw new Exception("Subject Code must have 3-50 character and don't have special characters");
//        }
//        if (!validate(subjectsDTO.getName(), String.valueOf(ConstantsRegex.NAME_PATTERN))) {
//            throw new Exception("Subject name is not contain special characters");
//        }
//        if (!validate(subjectsDTO.getStatus(), String.valueOf(ConstantsRegex.STATUS_PATTERN))) {
//            throw new Exception("Subject status must be active or inactive");
//        }
    }


    public void validateIterations(IterationsDTO iterationsDTO) throws Exception {
        if (iterationsRepository.findByIterationsName(iterationsDTO.getName()) > 0) {
            throw new Exception("Iterations Name already exist ");
        }
        if (!subjectsRepository.existsById(iterationsDTO.getSubjectId())) {
            throw new Exception("Id of subject not found");
        }
        if (!validate(iterationsDTO.getName(), String.valueOf(ConstantsRegex.NAME_PATTERN))) {
            throw new Exception("Iterations name is not contain special characters");
        }
        if (!validate(iterationsDTO.getDuration().toString(), String.valueOf(ConstantsRegex.NUMBER_PATTERN))) {
            throw new Exception("Iterations duration must be integer");
        }


    }

    public void validateUsersAdd(UsersDTO userDTO) throws Exception {
//
//        if (!validate(userDTO.getUsername(), String.valueOf(ConstantsRegex.USERNAME_PATTERN))) {
//            throw new Exception("Username must have 5-20 character and not contain special characters");
//        }
//        if (userRepository.findByUsername(userDTO.getUsername()) != null) {
//            throw new Exception("Username is duplicate");
//        }
//        if (!validate(userDTO.getPassword(), String.valueOf(ConstantsRegex.PASSWORD_PATTERN))) {
//            throw new Exception("Password must have 8-20 character," +
//                    " must have uppercase, lowercase, number and special character ");
//        }
//        if (!validate(userDTO.getFullName(), String.valueOf(ConstantsRegex.FULLNAME_PATTERN))) {
//            throw new Exception("Full name must not contain special character and number");
//        }
////        if (!validate(userDTO.getBirthday(), String.valueOf(ConstantsRegex.DATE_PATTERN))) {
////            throw new Exception("Birth day must be format YYYY-MM-DD");
////        }
//        if (!validate(userDTO.getTel(), String.valueOf(ConstantsRegex.PHONE_PATTERN))) {
//            throw new Exception("Phone number must have 10 character");
//        }
//        if (!validate(userDTO.getEmail(), String.valueOf(ConstantsRegex.EMAIL_PATTERN))) {
//            throw new Exception("Email must be format abc@xyz.edg");
//        }
//        if (!validate(userDTO.getAvatarLink(), String.valueOf(ConstantsRegex.LINK_PATTERN))) {
//            throw new Exception("Wrong link");
//        }
//        if (!validate(userDTO.getFacebookLink(), String.valueOf(ConstantsRegex.LINK_PATTERN))) {
//            throw new Exception("Wrong link");
//        }
//        if (!validate(userDTO.getSettingsId().toString(), String.valueOf(ConstantsRegex.NUMBER_PATTERN))) {
//            throw new Exception("Id must be a integer");
//        }
//        if (!settingsRepository.existsById(userDTO.getSettingsId())) {
//            throw new Exception("Id of setting not found");
//        }
//
//        if (!validate(userDTO.getStatus(), String.valueOf(ConstantsRegex.STATUS_PATTERN))) {
//            throw new Exception("Status must be active or inactive");
//        }
    }

    public void validateUsersEdit(UsersDTO userDTO) throws Exception {

//        if (!validate(userDTO.getUsername(), String.valueOf(ConstantsRegex.USERNAME_PATTERN))) {
//            throw new Exception("Username must have 5-20 character and not contain special characters");
//        }
//        //cần check nếu trùng với hiện tại thì bỏ qua check duplicate
////        if(userRepository.findByUsername(userDTO.getUsername())!=null){
////            throw new Exception("Username is duplicate");
////        }
////        if (!validate(userDTO.getPassword(), String.valueOf(ConstantsRegex.PASSWORD_PATTERN))) {
////            throw new Exception("Password must have 8-20 character," +
////                    " must have uppercase, lowercase, number and special character ");
////        }
//        if (!StringUtils.isEmpty(userDTO.getFullName()) && (!validate(userDTO.getFullName(), String.valueOf(ConstantsRegex.FULLNAME_PATTERN)))) {
//            throw new Exception("Full name must not contain special character and number");
//        }
////        if (!StringUtils.isEmpty(userDTO.getBirthday()) && (!validate(userDTO.getBirthday(), String.valueOf(ConstantsRegex.DATE_PATTERN)))) {
////            throw new Exception("Birth day must be format ĐD-MM-YYYY");
////        }
//        if (!StringUtils.isEmpty(userDTO.getTel()) && (!validate(userDTO.getTel(), String.valueOf(ConstantsRegex.PHONE_PATTERN)))) {
//            throw new Exception("Phone number must have 10 character");
//        }
//        if (!StringUtils.isEmpty(userDTO.getEmail()) &&(!validate(userDTO.getEmail(), String.valueOf(ConstantsRegex.EMAIL_PATTERN)))) {
//            throw new Exception("Email must be format abc@xyz.edg");
//        }
//        if (!StringUtils.isEmpty(userDTO.getAvatarLink()) &&(!validate(userDTO.getAvatarLink(), String.valueOf(ConstantsRegex.LINK_PATTERN)))) {
//            throw new Exception("Wrong link");
//        }
//        if (!StringUtils.isEmpty(userDTO.getFacebookLink()) &&(!validate(userDTO.getFacebookLink(), String.valueOf(ConstantsRegex.LINK_PATTERN)))) {
//            throw new Exception("Wrong link");
//        }
//        //check if role=user => check setting id => loc tim ra nhung truong xua
//
//        if (userDTO.getSettingsId() != null &&(!validate(userDTO.getSettingsId().toString(), String.valueOf(ConstantsRegex.NUMBER_PATTERN)))) {
//            throw new Exception("Id must be a integer");
//        }
//        if (userDTO.getSettingsId() != null && !settingsRepository.existsById(userDTO.getSettingsId())) {
//            throw new Exception("Id of setting not found");
//        }
//        if (!StringUtils.isEmpty(userDTO.getStatus()) &&(!validate(userDTO.getStatus(), String.valueOf(ConstantsRegex.STATUS_PATTERN)))) {
//            throw new Exception("Status must be active or inactive");
//        }

    }

    public void validateSetting(SettingsDTO settingsDTO) throws Exception {

        if (ObjectUtils.isEmpty(settingsDTO.getTitle())) {
            throw new Exception("Title can't be empty");
        }
        if (!validate(settingsDTO.getTitle(), String.valueOf(ConstantsRegex.FULLNAME_PATTERN))) {
            throw new Exception("Title must not contain special character and number");
        }
        if (ObjectUtils.isEmpty(settingsDTO.getValue())) {
            throw new Exception("Value can't be empty");
        }
        //displayOrder check trùng trong phạm vi type id
        if (ObjectUtils.isEmpty(settingsDTO.getTitle())) {
            throw new Exception("Title can't be empty");
        }
        if (ObjectUtils.isEmpty(settingsDTO.getTypeId())) {
            throw new Exception("TypeID can't be empty");
        }
        if (ObjectUtils.isEmpty(settingsDTO.getDisplayOrder())) {
            throw new Exception("DisplayOrder can't be empty");
        }
        if (ObjectUtils.isEmpty(settingsDTO.getStatus())
                ||!validate(settingsDTO.getStatus(), String.valueOf(ConstantsRegex.STATUS_PATTERN))) {
            throw new Exception("Status must be active or inactive");
        }
    }
}
