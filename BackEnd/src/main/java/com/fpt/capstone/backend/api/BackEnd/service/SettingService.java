package com.fpt.capstone.backend.api.BackEnd.service;

import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Settings;

import java.util.List;

public interface SettingService {

    SettingsDTO addSettings(SettingsDTO settingsDTO);

    void deleteSetting(int id);

    List<SettingsDTO> showSettingsList();

    SettingsDTO updateSetting(SettingsDTO settingsDTO);

    List<Settings> listBy(String keyword);

}
