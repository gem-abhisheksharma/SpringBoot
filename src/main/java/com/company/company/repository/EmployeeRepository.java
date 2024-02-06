package com.company.company.repository;

import com.company.company.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {
    void deleteByEmployeeId(String employeeId);

    Employee findByEmployeeId(String employeeId);
}
