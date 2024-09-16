package com.hajer.DataDoor.Implements;

import com.hajer.DataDoor.Dto.AccountDto;
import com.hajer.DataDoor.Exceptions.OperationNonPermittedException;
import com.hajer.DataDoor.Models.Account;
import com.hajer.DataDoor.Repositories.AccountRepostitory;
import com.hajer.DataDoor.Services.AccountService;
import com.hajer.DataDoor.Validators.Objectsvalidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepostitory repository;
    private final Objectsvalidator<AccountDto> validator;
    @Override
    public Integer save(AccountDto dto) {
        //block account update-> iban cannot be changed
        /*if(dto.getId() !=null){
        throw  new OperationNonPermittedException(
                "Accound cannot be updated",
                "save accound",
                "Accound",
                 "Update not permitted"

        )
        }*/
        //valide object
        validator.validate(dto);
        //transform object to entity
        Account account= AccountDto.toEntity(dto);
        boolean userHasAlreadyAnAccound=repository.findByUserId(account.getUser().getId()).isPresent();

        if(userHasAlreadyAnAccound ){
            throw  new OperationNonPermittedException(
                    "the selected user has already an active account",
                    "create account",
                    "account service",
                    "account creation");
        }
        //generate random Iban

        if(dto.getId() ==null) {
            account.setIban(generateRandomIban());
        }
        //renvoyer object by id
        return repository.save(account).getId();
    }

    @Override
    public List<AccountDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto findById(Integer id) {
        return repository.findById(id)
                .map(AccountDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("No account was found with the provided ID"+ id));

    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);

    }


    private String generateRandomIban(){
        //generate iban
        String iban= Iban.random(CountryCode.DE).toFormattedString();

        //check if iban already existe
        boolean ibanExiste= repository.findByIban(iban).isPresent();

        //if existe --< generate new random iban
        if(ibanExiste){
            generateRandomIban();
        }

        //if not existe return generated iban
        return iban;

    }
}
