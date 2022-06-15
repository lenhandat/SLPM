package com.fpt.capstone.backend.api.BackEnd.service.impl;

import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.UsersDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import com.fpt.capstone.backend.api.BackEnd.repository.SettingsRepository;
import com.fpt.capstone.backend.api.BackEnd.service.ConstantsStatus;
import com.fpt.capstone.backend.api.BackEnd.service.SettingService;
import com.fpt.capstone.backend.api.BackEnd.service.validate.Validate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class SettingsServiceImpl implements SettingService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    private SettingsRepository settingsRepository;

    @Autowired
    private Validate validate;

    @Override
    public List<Settings> getTypeSetting() {
        return settingsRepository.getTypeSeting();
    }

    @Override
    public Page<SettingsDTO> getSetingByType(int id,String value, int page, int per_page) {
        Pageable pageable = PageRequest.of(page - 1, per_page);
        return settingsRepository.getSetingByType(id,value, pageable);
    }
    @Override
    public SettingsDTO addSettings(SettingsDTO settingsDTO) {
//        validate.validateSetting(settingsDTO);
        settingsDTO.setStatus(ConstantsStatus.active.toString());
        settingsRepository.save(mapper.map(settingsDTO, Settings.class));
        return settingsDTO;
    }

    @Override
    public void deleteSetting(int id) {
        settingsRepository.deleteSettingById(id);
    }
    @Override
    public void updateSetting(SettingsDTO settingsDTO) throws ParseException {
        Settings settings = settingsRepository.getOne(settingsDTO.getId());
        settings = convertToEntity(settingsDTO);
         settingsRepository.save(settings);

    }

    private Settings convertToEntity(SettingsDTO settingsDTO) throws ParseException {
        Settings settings = mapper.map(settingsDTO, Settings.class);
        return settings;
    }
    //
    @Override
    public SettingsDTO getSettingDetail(int id) {
        return mapper.map(settingsRepository.findById(id), SettingsDTO.class);
    }

//    public List<SettingsDTO> showSettingsList(int page, int size) {
//        Page<Settings> settings = settingsRepository.findAll(PageRequest.of(page, size));
//        List<SettingsDTO> settingsDTOS = settings.stream()
//                .map(setting -> mapper.map(setting, SettingsDTO.class))
//                .collect(Collectors.toList());
//        return settingsDTOS;
//    }
//
//
//    @Override
//    public Page<SettingsDTO> listBy(String keyTitle, String keyValue, int page, int per_page) {
//        Pageable pageable = PageRequest.of(page - 1, per_page);
//        return settingsRepository.search(keyTitle, keyValue, pageable);
//    }
//
//
//    @Override
//    public Integer getTotalSetting(String keyTitle, String keyValue) {
//
//        return settingsRepository.getTotalSetting(keyTitle, keyValue);
//    }
//
//    @Override
//    public List<SettingsDTO> showSettingsList() {
//        List<Settings> settings = settingsRepository.findAll();
//        List<SettingsDTO> settingsDTOS = settings.stream()
//                .map(setting -> mapper.map(setting, SettingsDTO.class))
//                .collect(Collectors.toList());
//        return settingsDTOS;
//    }

}
