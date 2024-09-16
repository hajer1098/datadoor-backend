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

public class Contact extends EntityAbstract {



    @Column(name ="prenom")
    private String firstname;

    @Column(name ="nom")
    private String lastname;

    @Column
    private  String email;

    @Column
    private  String iban;

    @ManyToOne()
    @JoinColumn(name="id_user")
    private User user;

}

