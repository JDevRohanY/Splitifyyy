package com.example.JdevRohan.splitify.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createAt;
    private Date lastModifiedAt;
}

//MappedSuperclass - It is used so that the table for only child class should be created, table for parent class will not be created.
//Id signifies the primary key for the table, so for all the tables id will be the primary key, as all other tables are extending baseModel class.
//Generated value, it is auto assignment strategy for a key value.