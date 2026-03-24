package com.example.JdevRohan.splitify.controllers;

import com.example.JdevRohan.splitify.dtos.SettleUpGroupRequestDto;
import com.example.JdevRohan.splitify.dtos.SettleUpGroupResponseDto;
import com.example.JdevRohan.splitify.dtos.SettleUpUserRequestDto;
import com.example.JdevRohan.splitify.dtos.SettleUpUserResponseDto;
import com.example.JdevRohan.splitify.exceptions.UserNotFoundException;
import com.example.JdevRohan.splitify.models.Expense;
import com.example.JdevRohan.splitify.services.SettleUpService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/settleUp")
public class SettleUpController {
    private SettleUpService settleUpService;
    public SettleUpController(SettleUpService settleUpService){
        this.settleUpService = settleUpService;
    }

    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto settleUpRequestDto){
        SettleUpGroupResponseDto responseDto = new SettleUpGroupResponseDto();
        List<Expense> expenses = settleUpService.settleUpGroup(settleUpRequestDto.getGroupId());
        responseDto.setExpenses(expenses);
        return responseDto;
    }

    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto settleUpUserRequestDto) throws UserNotFoundException {
        SettleUpUserResponseDto responseDto = new SettleUpUserResponseDto();
        List<Expense> expenses = settleUpService.settleUpUser(settleUpUserRequestDto.getUserId());
        responseDto.setExpenses(expenses);
        return responseDto;
    }
}
