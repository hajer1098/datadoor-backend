package com.hajer.DataDoor.Implements;

import com.hajer.DataDoor.Dto.ContactDto;
import com.hajer.DataDoor.Models.Contact;
import com.hajer.DataDoor.Repositories.ContactRespository;
import com.hajer.DataDoor.Services.ContactService;
import com.hajer.DataDoor.Validators.Objectsvalidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRespository repository;
    private final Objectsvalidator<ContactDto> validator;

    @Override
    public Integer save(ContactDto dto) {
        //valide object
        validator.validate(dto);
        //transform object to entity
        Contact contact= ContactDto.toEntity(dto);
        //renvoyer object by id
        return repository.save(contact).getId();
    }

    @Override
    public List<ContactDto> findAll() {
        return repository.findAll()
                .stream()
                .map(ContactDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto findById(Integer id) {
        return repository.findById(id)
                .map(ContactDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("No contact was found with the provided ID"+ id));

    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<ContactDto> findAllByUserId(Integer userId) {
        return repository.findAllByUserId(userId)
                .stream()
                .map(ContactDto::fromEntity)
                .collect(Collectors.toList());


    }
}
