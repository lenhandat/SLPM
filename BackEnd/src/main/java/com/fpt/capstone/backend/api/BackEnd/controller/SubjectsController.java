package com.fpt.capstone.backend.api.BackEnd.controller;

import com.fpt.capstone.backend.api.BackEnd.dto.SubjectsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.SubjectsListDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.ApiResponse;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponsePaggingObject;
import com.fpt.capstone.backend.api.BackEnd.service.impl.SubjectsServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subject")
@PreAuthorize("hasAuthority('Admin')")
@CrossOrigin(origins = "/*", maxAge = 3600)
public class SubjectsController {

    @Autowired
    private SubjectsServiceImpl subjectsService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/add")
    public ResponseEntity<?> addSubject(@RequestBody SubjectsDTO subjectsDTO) {
        ResponsePaggingObject response = new ResponsePaggingObject();
        try {
            response.setSuccess(true);
            response.setMessage("Add subject successfully");
            response.setData(subjectsService.addSubjects(subjectsDTO));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Add subject fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSubject(@RequestParam(name = "id") String id) {
        ResponsePaggingObject response = new ResponsePaggingObject();
        try {
            response.setSuccess(true);
            response.setMessage("Delete subject successfully");
            subjectsService.deleteSubjects(Integer.parseInt(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Delete subject fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getList")
    public ResponseEntity<?> getListSubject() {
        ResponsePaggingObject response = new ResponsePaggingObject();
        try {
            response.setSuccess(true);
            response.setMessage("Add subject successfully");
            response.setData(subjectsService.showSubjectsList());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Add subject fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findSubjectByID(@RequestParam(name = "id") String id) {
        ResponsePaggingObject response = new ResponsePaggingObject();
        try {
            response.setSuccess(true);
            response.setMessage("Get subject successfully");
            response.setData(subjectsService.findById(Integer.parseInt(id)));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Get subject fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editSubject(@RequestBody SubjectsDTO subjectsDTO) throws Exception {
        ResponsePaggingObject response = new ResponsePaggingObject();
        try {
            response.setSuccess(true);
            response.setMessage("Update subject successfully");
            subjectsService.updateSubject(subjectsDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Update subject fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> findSettingBy(
//            @RequestParam("key_code") String key_code,
//                                           @RequestParam("key_status") String key_status,
//                                           @RequestParam("key_name") String key_name,
//                                           @RequestParam("page") int page,
//                                           @RequestParam("per_page") int per_page
    ) {
        ApiResponse response = new ApiResponse();
        try {
            List<SubjectsListDTO> subjects = subjectsService.listBy();
           // List<SubjectsListDTO> subjectsDTOS = subjects.getContent();
            response.setSuccess(true);
            response.setMessage("Get list subject successfully");
            response.setData(subjects);
//            response.setTotal(subjects.getTotalElements());
//            response.setCurrentPage(page);
//            response.setPerPages(per_page);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Get list subject fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
