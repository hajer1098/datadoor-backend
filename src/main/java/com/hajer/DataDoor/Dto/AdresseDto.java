package com.hajer.DataDoor.Dto;

import com.hajer.DataDoor.Models.Adresse;
import com.hajer.DataDoor.Models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AdresseDto {

    private Integer id;

    private String street;

    private Integer houseNumber;

    private  String zipCode;

    private String city;



    private  Integer userId;

    public  static  AdresseDto fromEntity(Adresse address){
        return AdresseDto.builder()
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .userId(address.getUser().getId())
                .build();
    }

    public  static  Adresse toEntity(AdresseDto address){
        return Adresse.builder()
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .zipCode(address.getZipCode())
                .city(address.getCity())

                .user(User.builder().id(address.getUserId()).build())
                .build();
    }
}
