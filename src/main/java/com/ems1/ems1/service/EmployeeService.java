package com.ems1.ems1.service;

import com.ems1.ems1.entities.Employee;
import com.ems1.ems1.payload.EmployeeDTO;
import com.ems1.ems1.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
        Employee employee=new Employee();
        employee.setName(employeeDTO.getName());
        employee.setMobile(employeeDTO.getMobile());
        Employee savedEmployee=employeeRepository.save(employee);
        EmployeeDTO savedEmployeeDTO=mapEmployeeToDTO(savedEmployee);
        return  savedEmployeeDTO;
}
private  EmployeeDTO mapEmployeeToDTO(Employee employee){
        EmployeeDTO employeeDTO=new EmployeeDTO();
        employeeDTO.setEid(employee.getEid());
        employeeDTO.setName(employee.getName());
        employeeDTO.setMobile(employee.getMobile());
        return employeeDTO;
}
}
