package com.fpt.capstone.backend.api.BackEnd.service;

import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import com.fpt.capstone.backend.api.BackEnd.repository.SettingsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SettingsService {

    ModelMapper mapper = new ModelMapper();

    @Autowired
    private SettingsRepository settingsRepository;


    public SettingsDTO addSettings(SettingsDTO settingsDTO) {
        java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());
        settingsDTO.setCreated(date);
        settingsDTO.setModified(date);
        settingsRepository.save(mapper.map(settingsDTO, Settings.class));
        return settingsDTO;

    }

    public void deleteSetting(int id) {
        settingsRepository.deleteById(id);
    }

    public List<SettingsDTO> settingsDTOList() {
        List<Settings> settings = settingsRepository.findAll();
        List<SettingsDTO> settingsDTOS = settings.stream()
                .map(setting -> mapper.map(setting, SettingsDTO.class))
                .collect(Collectors.toList());
        return settingsDTOS;
    }

    public SettingsDTO updateSetting(SettingsDTO settingsDTO){
        java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());
        settingsDTO.setModified(date);
        Settings settings = settingsRepository.getOne(settingsDTO.getId());

        settings.setTypeId(settingsDTO.getTypeId());
        settings.setTitle(settingsDTO.getTitle());
        settings.setValue(settingsDTO.getValue());
        settings.setDisplayOrder(settingsDTO.getDisplayOrder());
        settings.setStatus(settingsDTO.getStatus());
        settings.setModified(settingsDTO.getModified());
        settings.setModifiedBy(settingsDTO.getModifiedBy());

        settingsRepository.save(settings);
        return settingsDTO;

    }
}
