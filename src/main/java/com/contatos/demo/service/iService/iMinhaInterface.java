package com.contatos.demo.service.iService;

import java.util.List;


public interface iMinhaInterface<T, ID> {
    
    public T create(T t);
    public List<T> findAll();
    public T findById(ID id) throws Exception;
    public T update(ID id, T dto) throws Exception;
    public T delete(ID id) throws Exception;
    
}
