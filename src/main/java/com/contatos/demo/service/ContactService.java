package com.contatos.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.contatos.demo.model.Contact;
import com.contatos.demo.model.dto.ContactDto;
import com.contatos.demo.repository.ContactRepository;
import com.contatos.demo.service.iService.iMinhaInterface;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactService implements iMinhaInterface<ContactDto, Long>{
    
    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper; //tem a opção do new sem o configuration

    @Override
    public ContactDto create(ContactDto dto){
        
        Contact contact = modelMapper.map(dto, Contact.class);
        contactRepository.save(contact);
        return modelMapper.map(contact, ContactDto.class);

    }

    public List<ContactDto> findAll() {
        
        List<Contact> contacts = contactRepository.findAll();
        List<ContactDto> retorno = new ArrayList<ContactDto>();
        
        for (Contact contact : contacts) {
            retorno.add(modelMapper.map(contact, ContactDto.class));
        }

        return retorno;

    }

    public ContactDto findById(Long id) throws Exception {       
        
        Contact contact = contactRepository.getReferenceById(id);
        
        if (contact != null && contact.getId()>0) {
            return modelMapper.map(contact, ContactDto.class);
        } else {
            throw new Exception("Contato não encontrado!");
        }
        
    }

    public ContactDto update(Long id, ContactDto dto) throws Exception {
        
        var contactBanco = contactRepository.getReferenceById(id);

        if (contactBanco != null && contactBanco.getId() != null) {
            
            Contact contact = modelMapper.map(dto, Contact.class);
            contact.setId(id);
            contactRepository.save(contact);
            return modelMapper.map(contact, ContactDto.class);

        } else {

            throw new Exception("Contato não encontrado!");

        }

    }

    public ContactDto delete(Long id) throws Exception {

        var contactBanco = contactRepository.getReferenceById(id);
       
        if (contactBanco != null && contactBanco.getId() != null) {

            ContactDto contactDto = modelMapper.map(contactBanco, ContactDto.class);
            contactRepository.deleteById(id);
            return contactDto;
            
        } else {
            
            throw new Exception("Contato não encontrado!");

        }

    }

}

