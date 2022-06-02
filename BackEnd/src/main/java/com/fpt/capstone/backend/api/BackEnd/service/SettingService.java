package com.fpt.capstone.backend.api.BackEnd.service;

import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SettingService {

    SettingsDTO addSettings(SettingsDTO settingsDTO);

    void deleteSetting(int id);

    List<SettingsDTO> showSettingsList();

    SettingsDTO updateSetting(SettingsDTO settingsDTO);

    Page<Settings> listBy(String keyTitle, String keyValue, int page, int per_pag);

    Integer getTotalSetting(String keyTitle, String keyValue);
    public SettingsDTO findById(int id);
}
