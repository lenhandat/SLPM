package com.fpt.capstone.backend.api.BackEnd.controller;

import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponseObject;
import com.fpt.capstone.backend.api.BackEnd.service.impl.SettingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("setting")
public class SettingsController {

    @Autowired
    private SettingsServiceImpl settingsService;

    @PostMapping("/add_setting")
    public ResponseEntity<?> addSetting(@RequestBody SettingsDTO settingsDTO) throws Exception{
        ResponseObject response = new ResponseObject();
        try {
            response.setStatus("OK");
            response.setMessage("Add setting success");
            response.setData(settingsService.addSettings(settingsDTO));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setStatus("Fail");
            response.setMessage("Add setting fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/delete_setting/{id}")
    public ResponseEntity<?> deleteSetting(@PathVariable("id") int id){
        ResponseObject response = new ResponseObject();
        try {
            response.setStatus("OK");
            response.setMessage("Delete setting success");
            settingsService.deleteSetting(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setStatus("Fail");
            response.setMessage("Delete setting fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show_list_setting")
    public ResponseEntity<?> showListSetting(){
        ResponseObject response = new ResponseObject();
        try {
            response.setStatus("OK");
            response.setMessage("Show list setting success");
            response.setData(settingsService.showSettingsList());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setStatus("Fail");
            response.setMessage("Show list setting fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/edit_setting")
    public ResponseEntity<?> editSetting(@RequestBody SettingsDTO settingsDTO) throws Exception{
        ResponseObject response = new ResponseObject();
        try {
            response.setStatus("OK");
            response.setMessage("Edit setting success");
            response.setData(settingsService.updateSetting(settingsDTO));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setStatus("Fail");
            response.setMessage("Edit setting fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findSettingByTile")
    public ResponseEntity<?> findSettingByTile(@RequestParam("key") String key){
        ResponseObject response = new ResponseObject();
        try {
            response.setStatus("OK");
            response.setMessage("Show list search setting success");
            response.setData(settingsService.listBy(key));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setStatus("Fail");
            response.setMessage("Show list search setting fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
