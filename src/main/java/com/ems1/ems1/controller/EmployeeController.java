package com.ems1.ems1.controller;

import com.ems1.ems1.entities.Employee;
import com.ems1.ems1.entities.Salary;
import com.ems1.ems1.payload.EmployeeDTO;
import com.ems1.ems1.payload.SalaryDTO;
import com.ems1.ems1.service.EmployeeService;
import com.ems1.ems1.service.SalaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private  final EmployeeService employeeService;
    private final SalaryService salaryService;

    public EmployeeController(EmployeeService employeeService, SalaryService salaryService) {
        this.employeeService = employeeService;
        this.salaryService = salaryService;
    }

   // public EmployeeController(EmployeeService employeeService) {
        //this.employeeService = employeeService;
    //}
    //http://localhost:8081/api/employee
    @PostMapping
    public ResponseEntity<EmployeeDTO>createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployeeDTO=employeeService.createEmployee(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployeeDTO);
    }
    //http://localhost:8081/api/employee/2/salary
    @PostMapping("/{id}/salary")
    public ResponseEntity<SalaryDTO>createSalary(@PathVariable("id") long id,@RequestBody SalaryDTO salaryDTO){
   SalaryDTO dto=salaryService.createSalary(id,salaryDTO) ;
   return  new ResponseEntity<>(dto,HttpStatus.CREATED);
    }
}
