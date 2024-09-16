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
public class Account extends EntityAbstract {

    private String iban;

    @OneToOne

    @JoinColumn(name = "id_user")
    private User user;


}
