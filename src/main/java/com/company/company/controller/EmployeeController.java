package com.company.company.controller;

import com.company.company.dto.EmployeeDTO;
import com.company.company.model.Employee;
import com.company.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;
    @GetMapping("/employee")
    public ResponseEntity<?> readEmployeeData()
    {
        return new ResponseEntity<>(employeeService.readAllEmployeesData(),HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> addEmployeeData(@RequestBody Employee employee){
        boolean employeeFlag = employeeService.createEmployeeData(employee);
        if(employeeFlag){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/employee")
    public ResponseEntity<?> updateEmployeeData(@RequestBody Employee employeeData){
        Employee updatedEmployeeData = employeeService.updateEmployeeData(employeeData);
        if(updatedEmployeeData != null){
            return new ResponseEntity<>(new EmployeeDTO(updatedEmployeeData),HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/employee")
    public ResponseEntity<?> deleteEmployeeData(@RequestParam String id){
        employeeService.deleteEmployeeData(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
