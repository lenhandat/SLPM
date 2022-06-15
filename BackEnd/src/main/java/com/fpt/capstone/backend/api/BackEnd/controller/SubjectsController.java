package com.fpt.capstone.backend.api.BackEnd.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subject")
@CrossOrigin(origins = "/*", maxAge = 3600)
public class SubjectsController {

//    @Autowired
//    private SubjectsServiceImpl subjectsService;
//
//    @Autowired
//    ModelMapper modelMapper;
//
//    @PostMapping("/add")
//    public ResponseEntity<?> addSubject(@RequestBody SubjectsDTO subjectsDTO) {
//        ResponseObject response = new ResponseObject();
//        try {
//            response.setSuccess(true);
//            response.setMessage("Add subject successfully");
//            response.setData(subjectsService.addSubjects(subjectsDTO));
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            response.setSuccess(false);
//            response.setMessage("Add subject fail " + "Message:" + e.getMessage());
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<?> deleteSubject(@RequestParam(name = "id") String id) {
//        ResponseObject response = new ResponseObject();
//        try {
//            response.setSuccess(true);
//            response.setMessage("Delete subject successfully");
//            subjectsService.deleteSubjects(Integer.parseInt(id));
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            response.setSuccess(false);
//            response.setMessage("Delete subject fail " + "Message:" + e.getMessage());
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/getList")
//    public ResponseEntity<?> getListSubject() {
//        ResponseObject response = new ResponseObject();
//        try {
//            response.setSuccess(true);
//            response.setMessage("Add subject successfully");
//            response.setData(subjectsService.showSubjectsList());
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            response.setSuccess(false);
//            response.setMessage("Add subject fail " + "Message:" + e.getMessage());
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/findById")
//    public ResponseEntity<?> findSubjectByID(@RequestParam(name = "id") String id) {
//        ResponseObject response = new ResponseObject();
//        try {
//            response.setSuccess(true);
//            response.setMessage("Get subject successfully");
//            response.setData(subjectsService.findById(Integer.parseInt(id)));
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            response.setSuccess(false);
//            response.setMessage("Get subject fail " + "Message:" + e.getMessage());
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PostMapping("/edit")
//    public ResponseEntity<?> editSubject(@RequestBody SubjectsDTO subjectsDTO) throws Exception {
//        ResponseObject response = new ResponseObject();
//        try {
//            response.setSuccess(true);
//            response.setMessage("Update subject successfully");
//            subjectsService.updateSubject(subjectsDTO);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            response.setSuccess(false);
//            response.setMessage("Update subject fail " + "Message:" + e.getMessage());
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<?> findSettingBy(@RequestParam("key_code") String key_code,
//                                           @RequestParam("key_status") String key_status,
//                                           @RequestParam("key_name") String key_name,
//                                           @RequestParam("page") int page,
//                                           @RequestParam("per_page") int per_page
//    ) {
//        ResponsePaggingObject response = new ResponsePaggingObject();
//        try {
//            Page<SubjectsDTO> subjects = subjectsService
//                    .listBy(key_code, key_name, key_status, page, per_page);
//            List<SubjectsDTO> subjectsDTOS = subjects.getContent();
//            response.setSuccess(true);
//            response.setMessage("Get list subject successfully");
//            response.setData(subjectsDTOS);
//            response.setTotal(subjects.getTotalElements());
//            response.setCurrentPage(page);
//            response.setPerPages(per_page);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//
//        } catch (Exception e) {
//            response.setSuccess(false);
//            response.setMessage("Get list subject fail " + "Message:" + e.getMessage());
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//    }

}
