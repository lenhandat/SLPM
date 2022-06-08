package com.fpt.capstone.backend.api.BackEnd.controller;

import com.fpt.capstone.backend.api.BackEnd.dto.IterationsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.SettingsDTO;
import com.fpt.capstone.backend.api.BackEnd.dto.SubjectsDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.Iterations;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponseObject;
import com.fpt.capstone.backend.api.BackEnd.entity.ResponsePaggingObject;
import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import com.fpt.capstone.backend.api.BackEnd.service.impl.IterationsServiceImpl;
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
@RequestMapping("iterations")
@PreAuthorize("hasAuthority('ADMIN')")
public class IterationsController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private IterationsServiceImpl iterationsService;

    @PostMapping("/add")
    public ResponseEntity<?> addIteration(@RequestBody IterationsDTO iterationsDTO) {
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Add iterations successfully");
            response.setData(iterationsService.addIterations(iterationsDTO));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Add iterations fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<?> deleteIteration(@RequestParam(name = "id") String id) {
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Delete iteration successfully");
            iterationsService.deleteIterations(Integer.parseInt(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Delete iteration fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getList")
    public ResponseEntity<?> showListIterations() {
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Get list iterations successfully");
            response.setData(iterationsService.showIterationList());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Get list iterations fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findIterationsByID(@RequestParam(name = "id") String id) {
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Get iteration successfully");
            response.setData(iterationsService.findById(Integer.parseInt(id)));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage("Get iteration fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> findIterationsByTile(@RequestParam("key_name") String key_name,
            @RequestParam("page")  int page, @RequestParam("per_page") int per_page
    ) {
        ResponsePaggingObject response = new ResponsePaggingObject();
        try {
            Page<Iterations> iterations = iterationsService.listBy(key_name,page,per_page);
            List<IterationsDTO> iterationsDTOS = Arrays.asList(modelMapper.map(iterations.getContent(),IterationsDTO[].class));

            response.setSuccess(true);
            response.setMessage("Get list search iteration successfully");
            response.setData(iterationsDTOS);
            response.setTotal(iterations.getTotalElements());
            response.setCurrentPage(page);
            response.setPerPages(per_page);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Get list search iteration fail " + "Message:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editIterations(@RequestBody IterationsDTO iterationsDTO) throws Exception{
        ResponseObject response = new ResponseObject();
        try {
            response.setSuccess(true);
            response.setMessage("Add iteration successfully");
            iterationsService.updateIterations(iterationsDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage("Add iteration fail "+"Message:"+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
