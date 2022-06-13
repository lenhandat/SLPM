package com.fpt.capstone.backend.api.BackEnd.service.validate;

import com.fpt.capstone.backend.api.BackEnd.dto.IterationsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.SubjectsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.UserDTO;
import com.fpt.capstone.backend.api.BackEnd.repository.IterationsRepository;
import com.fpt.capstone.backend.api.BackEnd.repository.SettingsRepository;
import com.fpt.capstone.backend.api.BackEnd.repository.SubjectsRepository;
import com.fpt.capstone.backend.api.BackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Objects;


@Service
public class Validate {

    @Autowired
    private SubjectsRepository subjectsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SettingsRepository settingsRepository;
    @Autowired
    private IterationsRepository iterationsRepository;

    public boolean validate(String value, String regex) {
        return value.matches(regex);
    }

    public void validateSubject(SubjectsDTO subjectsDTO) throws Exception {
        if (ObjectUtils.isEmpty(subjectsDTO.getName())) {
            throw new Exception("Subjects Name can't be empty");
        }
        if (!validate(subjectsDTO.getName(), String.valueOf(ConstantsRegex.NAME_PATTERN))) {
            throw new Exception("Subject name is not contain special characters");
        }
        if (subjectsRepository.findBySubjectName(subjectsDTO.getName()) > 0) {
            throw new Exception("Subjects Name already exist ");
        }
        if (ObjectUtils.isEmpty(subjectsDTO.getCode())) {
            throw new Exception("Subjects Code can't be empty");
        }
        if (!validate(subjectsDTO.getCode(), String.valueOf(ConstantsRegex.CODE_PATTERN))) {
            throw new Exception("Subject Code must have 3-50 character and don't have special characters");
        }
        if (!validate(subjectsDTO.getStatus(), String.valueOf(ConstantsRegex.STATUS_PATTERN))
                ||ObjectUtils.isEmpty(subjectsDTO.getStatus())) {
            throw new Exception("Subject status must be active or inactive");
        }
    }


    public void validateIterations(IterationsDTO iterationsDTO) throws Exception {
        if (ObjectUtils.isEmpty(iterationsDTO.getName())) {
            throw new Exception("Iterations Name can't be empty");
        }
        if (!validate(iterationsDTO.getName(), String.valueOf(ConstantsRegex.NAME_PATTERN))) {
            throw new Exception("Iterations name is not contain special characters");
        }
        if (iterationsRepository.findByIterationsName(iterationsDTO.getName()) > 0) {
            throw new Exception("Iterations Name already exist ");
        }
        if (ObjectUtils.isEmpty(iterationsDTO.getSubjectId())) {
            throw new Exception("Id of subject can't be empty");
        }
        if (!subjectsRepository.existsById(iterationsDTO.getSubjectId())) {
            throw new Exception("Id of subject not found");
        }
        if (ObjectUtils.isEmpty(iterationsDTO.getDuration())) {
            throw new Exception("Iterations duration can't be empty");
        }
        if (!validate(iterationsDTO.getStatus(), String.valueOf(ConstantsRegex.STATUS_PATTERN))
                ||ObjectUtils.isEmpty(iterationsDTO.getStatus())) {
            throw new Exception("Iterations status must be active or inactive");
        }
    }

    public void validateUsersAdd(UserDTO userDTO) throws Exception {

        if (!validate(userDTO.getUsername(), String.valueOf(ConstantsRegex.USERNAME_PATTERN))
                ||ObjectUtils.isEmpty(userDTO.getUsername())) {
            throw new Exception("Username must have 5-20 character and not contain special characters");
        }
        if (userRepository.findByUsername(userDTO.getUsername()) != null) {
            throw new Exception("Username is duplicate");
        }
        if (!validate(userDTO.getPassword(), String.valueOf(ConstantsRegex.PASSWORD_PATTERN))
                ||ObjectUtils.isEmpty(userDTO.getPassword())) {
            throw new Exception("Password must have 8-20 character," +
                    " must have uppercase, lowercase, number and special character ");
        }
        if(ObjectUtils.isEmpty(userDTO.getFullName())){
            throw new Exception("Full name can't be empty");
        }
        if (!validate(userDTO.getFullName(), String.valueOf(ConstantsRegex.FULLNAME_PATTERN))) {
            throw new Exception("Full name must not contain special character and number");
        }
        if(ObjectUtils.isEmpty(userDTO.getBirthday())){
            throw new Exception("Birthday can't be empty");
        }
        if (!validate(userDTO.getTel(), String.valueOf(ConstantsRegex.PHONE_PATTERN))
                ||ObjectUtils.isEmpty(userDTO.getTel())) {
            throw new Exception("Phone number must have 10 character");
        }
        if (!validate(userDTO.getEmail(), String.valueOf(ConstantsRegex.EMAIL_PATTERN))
                ||ObjectUtils.isEmpty(userDTO.getEmail())) {
            throw new Exception("Email must be format abc@xyz.edg");
        }
        if (!validate(userDTO.getAvatarLink(), String.valueOf(ConstantsRegex.LINK_PATTERN))
                ||ObjectUtils.isEmpty(userDTO.getAvatarLink())) {
            throw new Exception("Wrong link");
        }
        if (!validate(userDTO.getFacebookLink(), String.valueOf(ConstantsRegex.LINK_PATTERN))
                ||ObjectUtils.isEmpty(userDTO.getFacebookLink())) {
            throw new Exception("Wrong link");
        }
        if (ObjectUtils.isEmpty(userDTO.getSettingsId())) {
            throw new Exception("Setting id can't be empty");
        }
        if (!settingsRepository.existsById(userDTO.getSettingsId())) {
            throw new Exception("Id of setting not found");
        }
        if (!validate(userDTO.getStatus(), String.valueOf(ConstantsRegex.STATUS_PATTERN))
                ||ObjectUtils.isEmpty(userDTO.getStatus())) {
            throw new Exception("Status must be active or inactive");
        }
    }

    public void validateUsersEdit(UserDTO userDTO) throws Exception {

        if (!validate(userDTO.getUsername(), String.valueOf(ConstantsRegex.USERNAME_PATTERN))
                ||ObjectUtils.isEmpty(userDTO.getUsername())) {
            throw new Exception("Username must have 5-20 character and not contain special characters");
        }
        //cần check nếu trùng với hiện tại thì bỏ qua check duplicate
//        if(userRepository.findByUsername(userDTO.getUsername())!=null){
//            throw new Exception("Username is duplicate");
//        }
        if(ObjectUtils.isEmpty(userDTO.getFullName())){
            throw new Exception("Full name can't be empty");
        }
        if (!validate(userDTO.getFullName(), String.valueOf(ConstantsRegex.FULLNAME_PATTERN))) {
            throw new Exception("Full name must not contain special character and number");
        }
        if(ObjectUtils.isEmpty(userDTO.getBirthday())){
            throw new Exception("Birthday can't be empty");
        }
        if (!validate(userDTO.getTel(), String.valueOf(ConstantsRegex.PHONE_PATTERN))
                ||ObjectUtils.isEmpty(userDTO.getTel())) {
            throw new Exception("Phone number must have 10 character");
        }
        if (!validate(userDTO.getEmail(), String.valueOf(ConstantsRegex.EMAIL_PATTERN))
                ||ObjectUtils.isEmpty(userDTO.getEmail())) {
            throw new Exception("Email must be format abc@xyz.edg");
        }
        if (!validate(userDTO.getAvatarLink(), String.valueOf(ConstantsRegex.LINK_PATTERN))
                ||ObjectUtils.isEmpty(userDTO.getAvatarLink())) {
            throw new Exception("Wrong link");
        }
        if (!validate(userDTO.getFacebookLink(), String.valueOf(ConstantsRegex.LINK_PATTERN))
                ||ObjectUtils.isEmpty(userDTO.getFacebookLink())) {
            throw new Exception("Wrong link");
        }
        //check if role=user => check setting id => loc tim ra nhung truong xua

        if (ObjectUtils.isEmpty(userDTO.getSettingsId())) {
            throw new Exception("Setting id can't be empty");
        }
        if (!settingsRepository.existsById(userDTO.getSettingsId())) {
            throw new Exception("Id of setting not found");
        }
        if (!validate(userDTO.getStatus(), String.valueOf(ConstantsRegex.STATUS_PATTERN))
                ||ObjectUtils.isEmpty(userDTO.getStatus())) {
            throw new Exception("Status must be active or inactive");
        }

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
        if (settingsRepository.searchByTypeIdDisplayOrder(settingsDTO.getTypeId(), settingsDTO.getDisplayOrder()) > 0) {
            throw new Exception("DisplayOrder already exist on this typeID");
        }
        if (!validate(settingsDTO.getStatus(), String.valueOf(ConstantsRegex.STATUS_PATTERN))
                ||ObjectUtils.isEmpty(settingsDTO.getStatus())) {
            throw new Exception("Status must be active or inactive");
        }
    }
}
