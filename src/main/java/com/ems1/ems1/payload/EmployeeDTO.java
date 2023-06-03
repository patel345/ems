package com.ems1.ems1.payload;

import com.ems1.ems1.entities.Salary;
import lombok.Data;

@Data
public class EmployeeDTO {
    private Long eid;
    private String name;
    private Long mobile;
    //private SalaryDTO salaryDTO;

}
