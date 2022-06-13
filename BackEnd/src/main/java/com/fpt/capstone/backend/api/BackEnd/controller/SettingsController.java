package com.fpt.capstone.backend.api.BackEnd.controller;

import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponseObject;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponsePaggingObject;
import com.fpt.capstone.backend.api.BackEnd.service.impl.SettingsServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("setting")
@PreAuthorize("hasAuthority('ADMIN')")
public class SettingsController {

    @Autowired
    private SettingsServiceImpl settingsService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/add")
    public ResponseEntity<?> addSetting(@RequestBody SettingsDTO settingsDTO) throws Exception {
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Add setting successfully");
            response.setData(settingsService.addSettings(settingsDTO));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Add setting fail: "  + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteSetting(@PathVariable("id") int id) {
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Delete setting successfully");
            settingsService.deleteSetting(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Delete setting fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getList")
    public ResponseEntity<?> showListSetting() {
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Get list setting successfully");
            response.setData(settingsService.showSettingsList());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Get list setting fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findByID(@PathVariable("id") int id) {
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Get setting successfully");
            response.setData(settingsService.findById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Get setting fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editSetting(@RequestBody SettingsDTO settingsDTO) throws Exception {
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Edit setting successfully");
            response.setData(settingsService.updateSetting(settingsDTO));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Edit setting fail: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> findSettingByTile(@RequestParam("key_title") String key_title
            , @RequestParam("key_value") String key_value, @RequestParam("page") int page
            , @RequestParam("per_page") int per_page
    ) {
        ResponsePaggingObject response = new ResponsePaggingObject();
        try {

            Page<SettingsDTO> settings = settingsService.listBy(key_title, key_value, page, per_page);
            List<SettingsDTO> settingsDTOS = Arrays.asList(modelMapper.map(settings.getContent(), SettingsDTO[].class));

            response.setSuccess(true);
            response.setMessage("Get setting list successfully");
            response.setData(settingsDTOS);
            response.setTotal(settings.getTotalElements());
            response.setPerPages(settings.getTotalPages());
            response.setCurrentPage(page);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Get setting list fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
