package com.company.company.dto;

import com.company.company.model.Employee;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String employeeId;
    private String employeeDept;

    public EmployeeDTO(Employee employee){
        this.setEmployeeId(employee.getEmployeeId());
        this.setEmployeeDept(employee.getEmployeeDept());
        this.setLastName(employee.getLastName());
        this.setFirstName(employee.getFirstName());
    }
}
