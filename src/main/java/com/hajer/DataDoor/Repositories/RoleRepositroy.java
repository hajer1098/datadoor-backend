package com.hajer.DataDoor.Repositories;


import com.hajer.DataDoor.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepositroy extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(String roleName);
}
