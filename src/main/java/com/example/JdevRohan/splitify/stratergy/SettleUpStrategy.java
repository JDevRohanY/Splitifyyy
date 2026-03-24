package com.example.JdevRohan.splitify.stratergy;

import com.example.JdevRohan.splitify.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);
}
