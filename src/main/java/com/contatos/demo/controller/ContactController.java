package com.contatos.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contatos.demo.model.dto.ContactDto;
import com.contatos.demo.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private ContactService contactService;
    
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<ContactDto> create(@RequestBody ContactDto contactDto){
        var dto = contactService.create(contactDto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ContactDto>> findAll(){
        var dtos = contactService.findAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}") 
    public ResponseEntity<ContactDto> findById(@PathVariable Long id) throws Exception{
        var dto = contactService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDto> update(@PathVariable Long id, @RequestBody ContactDto contactDto) throws Exception {
        var dto = contactService.update(id, contactDto);
        return ResponseEntity.ok(dto);
            
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity <?> delete(@PathVariable Long id) throws Exception {
        var dto = contactService.delete(id);
        return ResponseEntity.ok(dto);
    }
    
}
