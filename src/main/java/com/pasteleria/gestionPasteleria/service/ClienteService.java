package com.pasteleria.gestionPasteleria.service;

import java.util.List;
import com.pasteleria.gestionPasteleria.entity.ClienteEntity;


public interface ClienteService {
    public List<ClienteEntity> findAll();

    public List<ClienteEntity> findAllCustom();

    public ClienteEntity findById(long id);

    public ClienteEntity add(ClienteEntity c);

    public ClienteEntity update(ClienteEntity c);

    public ClienteEntity delete(ClienteEntity c);
}