package com.pasteleria.gestionPasteleria.service;

import java.util.List;
import com.pasteleria.gestionPasteleria.entity.CompraEntity;

public interface CompraService {
    public List<CompraEntity> findAll();

    public List<CompraEntity> findAllCustom();

    public CompraEntity findById(long id);

    public CompraEntity add(CompraEntity c);

    public CompraEntity update(CompraEntity c);

    public CompraEntity delete(CompraEntity c);
}