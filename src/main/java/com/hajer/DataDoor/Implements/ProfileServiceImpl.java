package com.hajer.DataDoor.Implements;

import com.hajer.DataDoor.Dto.ContactDto;
import com.hajer.DataDoor.Dto.ProfileDto;
import com.hajer.DataDoor.Models.Contact;
import com.hajer.DataDoor.Models.Profile;
import com.hajer.DataDoor.Repositories.ContactRespository;
import com.hajer.DataDoor.Repositories.ProfileRepostitory;
import com.hajer.DataDoor.Services.ProfileService;
import com.hajer.DataDoor.Services.UserService;
import com.hajer.DataDoor.Validators.Objectsvalidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepostitory repository;
    private final Objectsvalidator<ProfileDto> validator;
    @Override
    public Integer save(ProfileDto dto) {
        //valide object
        validator.validate(dto);
        //transform object to entity
        Profile profile= ProfileDto.toEntity(dto);
        //renvoyer object by id
        return repository.save(profile).getId();
    }

    @Override
    public List<ProfileDto> findAll() {
        return repository.findAll()
                .stream()
                .map(ProfileDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ProfileDto findById(Integer id) {
        return repository.findById(id)
                .map(ProfileDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("No profile was found with the provided ID"+ id));

    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
