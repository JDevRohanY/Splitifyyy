package com.example.JdevRohan.splitify.dtos;

import com.example.JdevRohan.splitify.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    private List<Expense> expenses;
}
