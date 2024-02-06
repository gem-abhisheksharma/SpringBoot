package com.company.company.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class Employee {
    @MongoId
    private ObjectId _id;
    private String firstName;
    private String lastName;
    private String employeeId;
    private String employeeDept;
}