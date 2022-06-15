package com.fpt.capstone.backend.api.BackEnd.service;

import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import org.springframework.data.domain.Page;

import java.text.ParseException;
import java.util.List;

public interface SettingService {
    public List<Settings> getTypeSetting();

    public Page<SettingsDTO> getSetingByType(int id, String value, int page, int per_page);

    public void deleteSetting(int id);

    public SettingsDTO addSettings(SettingsDTO settingsDTO);

    public void updateSetting(SettingsDTO settingsDTO) throws ParseException;

    public SettingsDTO getSettingDetail(int id);
}
