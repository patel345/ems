package com.ems1.ems1.service;

import com.ems1.ems1.entities.Employee;
import com.ems1.ems1.entities.Salary;
import com.ems1.ems1.payload.SalaryDTO;
import com.ems1.ems1.repository.EmployeeRepository;
import com.ems1.ems1.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SalaryRepository salaryRepository;
    public SalaryDTO createSalary(long id, SalaryDTO salaryDTO) {
        Employee employee=employeeRepository.findById(id).get();
        Salary salary=new Salary();
        salary.setAmount(salaryDTO.getAmount());
        salary.setEmployee(employee);
        Salary sal=salaryRepository.save(salary);
        SalaryDTO dto=new SalaryDTO();
        dto.setSid(sal.getSid());
        dto.setAmount(sal.getAmount());
        return  dto;
    }
}
