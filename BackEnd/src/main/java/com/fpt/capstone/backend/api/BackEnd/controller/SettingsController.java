package com.fpt.capstone.backend.api.BackEnd.controller;

import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponseObject;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponsePaggingObject;
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

    @PostMapping("/add")
    public ResponseEntity<?> addSetting(@RequestBody SettingsDTO settingsDTO) throws Exception{
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess("True");
            response.setMessage("Add setting success");
            response.setData(settingsService.addSettings(settingsDTO));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setSuccess("Fail");
            response.setMessage("Add setting fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteSetting(@PathVariable("id") int id){
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess("Su");
            response.setMessage("Delete setting success");
            settingsService.deleteSetting(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setSuccess("False");
            response.setMessage("Delete setting fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getList")
    public ResponseEntity<?> showListSetting(){
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess("True");
            response.setMessage("Show list setting success");
            response.setData(settingsService.showSettingsList());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setSuccess("False");
            response.setMessage("Show list setting fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findByID(@PathVariable("id") int id){
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess("True");
            response.setMessage("Get setting success");
            response.setData(settingsService.findById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setSuccess("False");
            response.setMessage("Show list setting fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editSetting(@RequestBody SettingsDTO settingsDTO) throws Exception{
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess("True");
            response.setMessage("Edit setting success");
            response.setData(settingsService.updateSetting(settingsDTO));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setSuccess("False");
            response.setMessage("Edit setting fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> findSettingByTile(@RequestParam("keyTitle") String keyTitle
            ,@RequestParam("keyValue") String keyValue){
        ResponsePaggingObject response = new ResponsePaggingObject();
        try {
            response.setSuccess("True");
            response.setMessage("Show list search setting success");
            response.setData(settingsService.listBy(keyTitle,keyValue));
            response.setTotal(settingsService.getTotalSetting(keyTitle,keyValue));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setSuccess("False");
            response.setMessage("Show list search setting fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
