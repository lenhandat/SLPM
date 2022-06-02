package com.fpt.capstone.backend.api.BackEnd.controller;

import com.fpt.capstone.backend.api.BackEnd.dto.IterationsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.SubjectsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Iterations;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponseObject;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponsePaggingObject;
import com.fpt.capstone.backend.api.BackEnd.entity.Subjects;
import com.fpt.capstone.backend.api.BackEnd.service.impl.SubjectsServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("subject")
public class SubjectsController {

    @Autowired
    private SubjectsServiceImpl subjectsService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/add")
    public ResponseEntity<?> addSubject(@RequestBody SubjectsDTO subjectsDTO) {
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Add subject success");
            response.setData(subjectsService.addSubjects(subjectsDTO));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage("Add subject fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable("id") int id) {
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Delete subject success");
            subjectsService.deleteSubjects(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage("Delete subject fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getList")
    public ResponseEntity<?> getListSubject() {
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Add subject success");
            response.setData(subjectsService.showSubjectsList());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage("Add subject fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findSubjectByID(@PathVariable("id") int id) {
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Get subject success");
            response.setData(subjectsService.findById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage("Get subject fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/edit")
    public ResponseEntity<?> editSubject(@RequestBody SubjectsDTO subjectsDTO) throws Exception{
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Add subject success");
            response.setData(subjectsService.updateSubject(subjectsDTO));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage("Add subject fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> findSettingByTile(@RequestParam("key_code") String key_code, @RequestParam("key_status") String key_status,
                                               @RequestParam("key_name") String key_name,                 @RequestParam("page")  int page, @RequestParam("per_page") int per_page
    ) {
        ResponsePaggingObject response = new ResponsePaggingObject();
        try {
            Page<Subjects> subjects = subjectsService.listBy(key_code,key_name,key_status,page,per_page);
            List<SubjectsDTO> subjectsDTOS = Arrays.asList(modelMapper.map(subjects.getContent(),SubjectsDTO[].class));

            response.setSuccess(true);
            response.setMessage("Show list search setting success");
            response.setData(subjectsDTOS);
            response.setTotal(subjects.getTotalElements());
            response.setCurrentPage(page);
            response.setPerPages(per_page);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Show list search setting fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
