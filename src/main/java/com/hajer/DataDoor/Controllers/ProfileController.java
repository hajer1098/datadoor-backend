package com.hajer.DataDoor.Controllers;

import com.hajer.DataDoor.Dto.AccountDto;
import com.hajer.DataDoor.Dto.ProfileDto;
import com.hajer.DataDoor.Services.AccountService;
import com.hajer.DataDoor.Services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profiles")
@AllArgsConstructor
public class ProfileController {
    private final ProfileService service;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody ProfileDto profileDto){

        return ResponseEntity.ok(service.save(profileDto));

    }
    @GetMapping("/")
    public ResponseEntity<List<ProfileDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileDto> findById(@PathVariable("profileId") Integer profileId){
        return ResponseEntity.ok((service.findById(profileId)));

    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> delete(@PathVariable("accountId") Integer accountId){
        service.delete(accountId);
        return ResponseEntity.accepted().build();
    }
}
