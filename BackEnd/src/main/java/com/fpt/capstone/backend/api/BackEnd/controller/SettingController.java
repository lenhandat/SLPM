package com.fpt.capstone.backend.api.BackEnd.controller;

import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import com.fpt.capstone.backend.api.BackEnd.service.SettingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("setting")
@CrossOrigin(origins = "/*", maxAge = 3600)
public class SettingController {
    @Autowired
   private ModelMapper modelMapper ;
    @Autowired
    private SettingService settingService;

    @GetMapping("/getType")
    public List<Settings> getType() {
        return settingService.getTypeSetting();
    }

    @GetMapping("/getSettingByType")
    public List<SettingsDTO> getSettingByTile(@RequestParam("key_id") int  key_id
            , @RequestParam("page") int page, @RequestParam("per_page") int per_page)
    {
        Page<SettingsDTO> settings = settingService.getSetingByType(key_id,page,per_page);
        List<SettingsDTO> settingsDTOS = Arrays.asList(modelMapper.map(settings.getContent(), SettingsDTO[].class));
        return settingsDTOS;
    }

}
