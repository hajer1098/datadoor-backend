package com.hajer.DataDoor.Controllers;

import com.hajer.DataDoor.Dto.AccountDto;
import com.hajer.DataDoor.Services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {
    private final AccountService service;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody AccountDto accountDto){

        return ResponseEntity.ok(service.save(accountDto));

    }
    @GetMapping("/")
    public ResponseEntity<List<AccountDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> findById(@PathVariable("accountId") Integer accountId){
        return ResponseEntity.ok((service.findById(accountId)));

    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> delete(@PathVariable("accountId") Integer accountId){
        service.delete(accountId);
        return ResponseEntity.accepted().build();
    }
}
