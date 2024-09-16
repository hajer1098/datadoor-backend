package com.hajer.DataDoor.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Adresse extends EntityAbstract {


    private String street;

    private Integer houseNumber;

    private  String zipCode;

    private String city;

    @OneToOne
    @JoinColumn(name="id_user")
    private User user;
}
