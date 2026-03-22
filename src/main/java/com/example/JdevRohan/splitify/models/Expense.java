package com.example.JdevRohan.splitify.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "expenses")
public class Expense extends BaseModel {
    //Primitive attributes
    private String description;
    private int amount;
    //Non primitive attributes
    @ManyToOne
    private User createBy;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @OneToMany
    private List<ExpenseUser> expenseUsers;
}

