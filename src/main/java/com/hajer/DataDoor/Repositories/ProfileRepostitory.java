package com.hajer.DataDoor.Repositories;

import com.hajer.DataDoor.Models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepostitory extends JpaRepository<Profile,Integer> {
}
