package com.hajer.DataDoor.Repositories;


import com.hajer.DataDoor.Models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRespository  extends JpaRepository<Contact,Integer> {
    List<Contact> findAllByUserId(Integer userId);
}
