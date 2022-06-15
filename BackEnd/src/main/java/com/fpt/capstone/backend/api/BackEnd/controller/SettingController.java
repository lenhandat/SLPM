package com.fpt.capstone.backend.api.BackEnd.controller;

import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.UsersDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponsePaggingObject;
import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import com.fpt.capstone.backend.api.BackEnd.service.SettingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getType() {
        ResponsePaggingObject response = new ResponsePaggingObject();
        try {
            response.setSuccess(true);
            response.setMessage("Get setting type successfully");
            response.setData(settingService.getTypeSetting());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Get setting type fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSubject(@RequestBody SettingsDTO settingsDTO) {
        ResponsePaggingObject response = new ResponsePaggingObject();
        try {
            response.setSuccess(true);
            response.setMessage("Add setting successfully");
            response.setData(settingService.addSettings(settingsDTO));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Add setting fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editSubject(@RequestBody SettingsDTO settingsDTO) {
        ResponsePaggingObject response = new ResponsePaggingObject();
        try {
            response.setSuccess(true);
            response.setMessage("Update setting successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Update setting fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getSettingByType")
    public ResponseEntity<?> getSettingByTile(
            @RequestParam("key_id") int  key_id,
            @RequestParam("key_value") String  key_value,
            @RequestParam("page") int page,
            @RequestParam("per_page") int per_page)
    {

        ResponsePaggingObject response = new ResponsePaggingObject();
        try {
            Page<SettingsDTO> settings = settingService.getSetingByType(key_id,key_value,page,per_page);
            List<SettingsDTO> settingsDTOS = Arrays.asList(modelMapper.map(settings.getContent(), SettingsDTO[].class));
            response.setSuccess(true);
            response.setMessage("Get list setting successfully");
            response.setData(settingsDTOS);
            response.setTotal(settings.getTotalElements());
            response.setCurrentPage(page);
            response.setPerPages(per_page);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Get list setting fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<?> deleteSetting(@RequestParam("key_id") int  key_id)
    {

        ResponsePaggingObject response = new ResponsePaggingObject();
        try {
            settingService.deleteSetting(key_id);
            response.setSuccess(true);
            response.setMessage("Delete setting successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Delete setting fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById")
    public ResponseEntity<?> getSettingDetail(@RequestParam("key_id") int  key_id)
    {
        ResponsePaggingObject response = new ResponsePaggingObject();
        try {
            response.setSuccess(true);
            response.setMessage("Get setting detail successfully");
            response.setData(settingService.getSettingDetail(key_id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Get setting detail fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
