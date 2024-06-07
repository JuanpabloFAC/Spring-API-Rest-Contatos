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
    public ContactDto create(@RequestBody ContactDto contactDto){
        return contactService.create(contactDto);
    }

    @GetMapping
    public List<ContactDto> findAll(){
        return contactService.findAll();
    }

    @GetMapping("/{id}") 
    public ResponseEntity<ContactDto> findById(@PathVariable long id){
    return contactService.findById(id)
            .map(record -> ResponseEntity.ok().body(record))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDto> update(@PathVariable long id, @RequestBody ContactDto contactDto) {
        return contactService.update(id, contactDto)
            .map(record -> ResponseEntity.ok().body(record))
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <?> delete(@PathVariable long id) {
        return contactService.delete(id)
            .map(record -> ResponseEntity.ok().body(record))
            .orElse(ResponseEntity.notFound().build());
    }
    
}
