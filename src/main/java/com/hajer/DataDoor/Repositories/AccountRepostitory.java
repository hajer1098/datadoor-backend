package com.hajer.DataDoor.Repositories;

import com.hajer.DataDoor.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepostitory extends JpaRepository<Account,Integer> {

    Optional<Account> findByIban(String iban);


    Optional<Account> findByUserId(Integer id);
}
