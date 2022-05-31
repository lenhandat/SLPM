package com.fpt.capstone.backend.api.BackEnd.service.impl;

import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import com.fpt.capstone.backend.api.BackEnd.repository.SettingsRepository;
import com.fpt.capstone.backend.api.BackEnd.service.ConstantsStatus;
import com.fpt.capstone.backend.api.BackEnd.service.SettingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SettingsServiceImpl implements SettingService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    private SettingsRepository settingsRepository;

    public SettingsDTO addSettings(SettingsDTO settingsDTO) {
        java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());
        settingsDTO.setCreated(date);
        settingsDTO.setModified(date);
        //Set open for status
        settingsDTO.setStatus(ConstantsStatus.open.toString());
        settingsRepository.save(mapper.map(settingsDTO, Settings.class));
        return settingsDTO;
    }

    public void deleteSetting(int id) {
        settingsRepository.deleteById(id);
    }
    public SettingsDTO findById(int id) {
     return   mapper.map(settingsRepository.findById(id), SettingsDTO.class);
//        return  settingMapper.toDto(settingsRepository.findById(id).get());
    }

//    public List<SettingsDTO> showSettingsList(int page, int size) {
//        Page<Settings> settings = settingsRepository.findAll(PageRequest.of(page, size));
//        List<SettingsDTO> settingsDTOS = settings.stream()
//                .map(setting -> mapper.map(setting, SettingsDTO.class))
//                .collect(Collectors.toList());
//        return settingsDTOS;
//    }

    public SettingsDTO updateSetting(SettingsDTO settingsDTO) {
        //check dto ton tai không
        java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());
        settingsDTO.setModified(date);
//        Settings settings = settingsRepository.getOne(settingsDTO.getId());
//        settings.setTypeId(settingsDTO.getTypeId());
//        settings.setTitle(settingsDTO.getTitle());
//        settings.setValue(settingsDTO.getValue());
//        settings.setDisplayOrder(settingsDTO.getDisplayOrder());
//        settings.setStatus(settingsDTO.getStatus());
//        settings.setModified(settingsDTO.getModified());
//        settings.setModifiedBy(settingsDTO.getModifiedBy());
        Settings settings = mapper.map(settingsDTO,Settings.class);
        settingsRepository.save(settings);
        return settingsDTO;

    }

    @Override
    public Page<Settings> listBy(String keyTitle, String keyValue,int page, int per_page) {
    Pageable pageable= PageRequest.of(page-1,per_page);
        return  settingsRepository.search(keyTitle,keyValue,pageable);



//        Page<Settings> settings = settingsRepository.search(keyTitle,keyValue,pageable);
//        Page<SettingsDTO> dtos  = settings.map(this::convertToObjectDto);
//
//        return dtos;
//
//        Page<Settings> entities = settingsRepository.search(keyTitle,keyValue,pageable);
//        Page<SettingsDTO> dtoPage = entities.map(new Function<Settings, SettingsDTO>() {
//            @Override
//            public SettingsDTO apply(Settings settings) {
//                SettingsDTO settingsDTO= new SettingsDTO();
//                return  settingsDTO;
//            }
//        });


    }
    private SettingsDTO convertToObjectDto(Object o) {
        SettingsDTO dto = new SettingsDTO();
        //conversion here
        return dto;
    }
    @Override
    public Integer getTotalSetting(String keyTitle, String keyValue) {

        return settingsRepository.getTotalSetting(keyTitle,keyValue);
    }
    @Override
    public List<SettingsDTO> showSettingsList() {
        List<Settings> settings = settingsRepository.findAll();
        List<SettingsDTO> settingsDTOS = settings.stream()
                .map(setting -> mapper.map(setting, SettingsDTO.class))
                .collect(Collectors.toList());
        return settingsDTOS;
    }

}
