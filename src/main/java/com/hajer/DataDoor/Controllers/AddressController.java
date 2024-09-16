package com.hajer.DataDoor.Controllers;


import com.hajer.DataDoor.Dto.AdresseDto;
import com.hajer.DataDoor.Services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("addresses")
@AllArgsConstructor

public class AddressController {

    private final AddressService service;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody AdresseDto adresseDto){

        return ResponseEntity.ok(service.save(adresseDto));

    }
    @GetMapping("/")
    public ResponseEntity<List<AdresseDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<AdresseDto> findById(@PathVariable("addressId") Integer addressId){
        return ResponseEntity.ok((service.findById(addressId)));

    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> delete(@PathVariable("addressId") Integer addressId){
        service.delete(addressId);
        return ResponseEntity.accepted().build();
    }

}
