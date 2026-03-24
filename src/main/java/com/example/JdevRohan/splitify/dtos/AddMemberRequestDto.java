package com.example.JdevRohan.splitify.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMemberRequestDto {
    private Long adminId;
    private Long groupId;
    private Long userId;
}
