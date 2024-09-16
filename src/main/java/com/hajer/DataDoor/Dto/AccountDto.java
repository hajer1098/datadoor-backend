package com.hajer.DataDoor.Dto;

import com.hajer.DataDoor.Models.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor

public class AccountDto {

    private Integer id;

    private String iban;

    private  UserDto user;


    public  static  AccountDto fromEntity(Account account){
        //null check
        return AccountDto.builder()
                .id(account.getId())
                .iban(account.getIban())
                .user(UserDto.fromEntity(account.getUser()))
                .build();
    }

    public  static  Account toEntity(AccountDto account){
        //null check
        return Account.builder()
                .id(account.getId())
                .iban(account.getIban())
                .user(UserDto.toEntity(account.getUser()))
                .build();
    }
}
