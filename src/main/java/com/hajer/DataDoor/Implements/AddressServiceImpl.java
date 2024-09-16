package com.hajer.DataDoor.Implements;

import com.hajer.DataDoor.Dto.AdresseDto;
import com.hajer.DataDoor.Models.Adresse;
import com.hajer.DataDoor.Repositories.AddressRepository;
import com.hajer.DataDoor.Services.AddressService;
import com.hajer.DataDoor.Validators.Objectsvalidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final Objectsvalidator<AdresseDto> validator;

    @Override
    public Integer save(AdresseDto dto) {
        //valide object
        validator.validate(dto);
        //transform object to entity
        Adresse address= AdresseDto.toEntity(dto);
        //renvoyer object by id
        return repository.save(address).getId();
    }

    @Override
    public List<AdresseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AdresseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AdresseDto findById(Integer id) {
        return repository.findById(id)
                .map(AdresseDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("No address was found with the provided ID"+ id));

    }

    @Override
    public void delete(Integer id) {
       repository.deleteById(id);
    }
}
