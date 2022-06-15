package com.fpt.capstone.backend.api.BackEnd.service;

import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SettingService {
    public List<Settings> getTypeSetting();
    public Page<SettingsDTO> getSetingByType(int id, int page, int per_page);
    public Settings save(Settings settings);
}
