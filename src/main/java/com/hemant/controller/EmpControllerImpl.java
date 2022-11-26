package com.hemant.controller;


import com.hemant.model.dto.EmpDto;
import com.hemant.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
@RequiredArgsConstructor
public class EmpControllerImpl implements EmpController{

    private final EmpService empService;

    @GetMapping("{empId}")
    public ResponseEntity<EmpDto> getEmpById(@PathVariable("empId") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(empService.getEmp(id));
    }
    @GetMapping
    public ResponseEntity<List<EmpDto>> getAllEmp(){
        return ResponseEntity.status(HttpStatus.OK).body(empService.getAllEmp());
    }
    @PostMapping
    public ResponseEntity<EmpDto> saveEmp(@RequestBody EmpDto empDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(empService.sameEmp(empDto));
    }
    @DeleteMapping({"{empId}"})
    public ResponseEntity<String> deleteEmp(@PathVariable Integer empId){
        return ResponseEntity.status(HttpStatus.OK).body(empService.deleteEmp(empId));
    }
}
