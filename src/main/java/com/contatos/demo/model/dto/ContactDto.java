package com.contatos.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactDto {
    Long id;
    String name;
    String email;
    String phone;

    public ContactDto(String name, String email){
        this.name = name;
        this.email = email;
    }
}
