package com.hajer.DataDoor.Controllers;

import com.hajer.DataDoor.Dto.ContactDto;
import com.hajer.DataDoor.Services.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contacts")
@AllArgsConstructor
public class ContactController {
    private final ContactService service;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody ContactDto contactDto){

        return ResponseEntity.ok(service.save(contactDto));

    }
    @GetMapping("/")
    public ResponseEntity<List<ContactDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<ContactDto> findById(@PathVariable("contactId") Integer contactId){
        return ResponseEntity.ok((service.findById(contactId)));

    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<Void> delete(@PathVariable("contactId") Integer contactId){
        service.delete(contactId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<List<ContactDto> >findAllByUserId(@PathVariable("userId") Integer userId){
        return ResponseEntity.ok((service.findAllByUserId(userId)));
    }
}
