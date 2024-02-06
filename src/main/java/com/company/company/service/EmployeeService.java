package com.company.company.service;

import com.company.company.model.Employee;
import com.company.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public boolean createEmployeeData(Employee employeeData){
        Employee savedEmployeeData = employeeRepository.save(employeeData);
        return savedEmployeeData == null;
    }

    public List<Employee> readAllEmployeesData() {
        return employeeRepository.findAll();
    }

    public void deleteEmployeeData(String employeeId) {
        employeeRepository.deleteByEmployeeId(employeeId);

    }

    public Employee updateEmployeeData(Employee employeeData) {
        Employee oldEmployeeData = employeeRepository.findByEmployeeId(employeeData.getEmployeeId());
        employeeData.set_id(oldEmployeeData.get_id());
        Employee updatedEmployeeData = employeeRepository.save(employeeData);
        return updatedEmployeeData;
    }
}
