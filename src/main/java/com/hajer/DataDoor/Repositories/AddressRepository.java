package com.hajer.DataDoor.Repositories;


import com.hajer.DataDoor.Models.Adresse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Adresse,Integer> {
}
