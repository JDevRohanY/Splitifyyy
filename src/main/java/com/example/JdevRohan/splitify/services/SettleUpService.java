package com.example.JdevRohan.splitify.services;

import com.example.JdevRohan.splitify.exceptions.UserNotFoundException;
import com.example.JdevRohan.splitify.models.Expense;
import com.example.JdevRohan.splitify.models.ExpenseUser;
import com.example.JdevRohan.splitify.models.User;
import com.example.JdevRohan.splitify.repositories.ExpenseUserRepository;
import com.example.JdevRohan.splitify.repositories.UserRepository;
import com.example.JdevRohan.splitify.stratergy.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;

    public SettleUpService(UserRepository userRepository, ExpenseUserRepository expenseUserRepository, SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Expense> settleUpGroup(Long groupId){
        /*
        1. Get the group with the given Group Id
        2. Get all the expenses of this groupId
        3. Call the settleUpStratergy to settle Up all the expense
         */
        return null;
    }

    public List<Expense> settleUpUser(Long userId) throws UserNotFoundException {
        //Check this user is present or not in the db
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with Id : " + userId + " not found.");
        }

        //If user is there, then find all the expenses of that user
        List<ExpenseUser> expenseUsers = expenseUserRepository.findByUser(optionalUser.get());

        //from the expenseUsers, find the user with the given ID
        Set<Expense> expensesToSettle = new HashSet<>();
        for(ExpenseUser expenseUser : expenseUsers){
            if(expenseUser.getUser().getId() == userId){
                expensesToSettle.add(expenseUser.getExpense());
            }
        }

        //Now we have all the expenses for that user, convert the set of expenses to list
        List<Expense> transactions = settleUpStrategy.settleUp(expensesToSettle.stream().toList());

        //Now we only need transactions of particular userId
        List<Expense> transactionsToReturn = new ArrayList<>();
        for(Expense expense : transactions){
            for(ExpenseUser user : expense.getExpenseUsers()){
                if(user.getUser().equals(user)){
                    transactionsToReturn.add(expense);
                    break;
                }
            }
        }
        return transactionsToReturn;
    }
}
