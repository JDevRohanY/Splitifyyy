package com.example.JdevRohan.splitify.stratergy;

import com.example.JdevRohan.splitify.models.Expense;
import com.example.JdevRohan.splitify.models.ExpenseType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        //This is a dummy logic, please check before implementation
        PriorityQueue<Expense> minHeap = new PriorityQueue<>(
                (a,b) -> a.getAmount() - b.getAmount()
        );
        PriorityQueue<Expense> maxHeap = new PriorityQueue<>(
                (a,b) -> b.getAmount() - a.getAmount()
        );

        //Now add the positives to maxHeap, and negatives to minHeap
        for(Expense expense : expenses){
            if(expense.getAmount()>0){
                maxHeap.add(expense);
            }else{
                minHeap.add(expense);
            }
        }

        //Now when we have expense, settle up
        List<Expense> transactionNeeded = new ArrayList<>();
        while(!maxHeap.isEmpty() && !minHeap.isEmpty()){
            Expense currExpense = new Expense();
            Expense expenseMax = maxHeap.poll();
            Expense expenseMin = minHeap.poll();

            //Now settle up the amount
            currExpense.setAmount(Math.min(expenseMax.getAmount(), expenseMin.getAmount()));
            currExpense.setExpenseType(ExpenseType.DUMMY);
            currExpense.setExpenseUsers(expenseMax.getExpenseUsers());

            transactionNeeded.add(currExpense);

            //Now add the remaining amount back to heap
            int leftAmount = expenseMax.getAmount()-Math.abs(expenseMin.getAmount());
            Expense remainingExpense = new Expense();
            if(leftAmount>0){
                remainingExpense.setAmount(leftAmount);
                remainingExpense.setExpenseUsers(expenseMax.getExpenseUsers());
                remainingExpense.setExpenseType(ExpenseType.REAL);
                maxHeap.add(remainingExpense);
            }else{
                remainingExpense.setAmount(leftAmount);
                remainingExpense.setExpenseUsers(expenseMin.getExpenseUsers());
                remainingExpense.setExpenseType(ExpenseType.REAL);
                minHeap.add(remainingExpense);
            }
        }
        return transactionNeeded;
    }
}
