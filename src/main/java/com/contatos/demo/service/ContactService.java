package com.contatos.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.contatos.demo.model.Contact;
import com.contatos.demo.model.dto.ContactDto;
import com.contatos.demo.repository.ContactRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactService {
    
    private ContactRepository contactRepository;

    
    public ContactDto serviceCreate(ContactDto dto){
        ModelMapper modelMapper = new ModelMapper();
        Contact contact = modelMapper.map(dto, Contact.class);
        contactRepository.save(contact);
        return modelMapper.map(contact, ContactDto.class);
    }

    public List<ContactDto> serviceFindAll() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                .map(contact -> new ContactDto(contact.getId(), contact.getName(), contact.getEmail(), contact.getPhone()))
                .collect(Collectors.toList());
    }

    public Optional<ContactDto> serviceFindById(long id){
        ModelMapper modelMapper = new ModelMapper();
        Optional<Contact> contactOptional = contactRepository.findById(id);
        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            return Optional.ofNullable(modelMapper.map(contact, ContactDto.class));
        } else {
            return Optional.empty();
        }
    }

    public Optional<ContactDto> serviceUpdate(long id, ContactDto dto){
        ModelMapper modelMapper = new ModelMapper();
        Optional<Contact> contactOptional = contactRepository.findById(id);
        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            modelMapper.map(dto, contact);
            contactRepository.save(contact);
            return Optional.ofNullable(modelMapper.map(contact, ContactDto.class));
        } else {
            return Optional.empty();
        }
    }

    public Optional<?> serviceDelete(long id){
        ModelMapper modelMapper = new ModelMapper();
        Optional<Contact> contactOptional = contactRepository.findById(id);
        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            ContactDto contactDto = modelMapper.map(contact, ContactDto.class);
            contactRepository.deleteById(id);
            return Optional.of(contactDto);
        } else {
            return Optional.empty();
        }

    }

}

