package com.pasteleria.gestionPasteleria.service;

import java.util.List;
import com.pasteleria.gestionPasteleria.entity.ProductoEntity;
import com.pasteleria.gestionPasteleria.entity.ProveedorEntity;


public interface ProveedorService {
    public List<ProveedorEntity> findAll();

    public List<ProveedorEntity> findAllCustom();

    public ProveedorEntity findById(long id);

    public ProveedorEntity add(ProveedorEntity p);

    public ProveedorEntity update(ProveedorEntity p);

    public ProveedorEntity delete(ProveedorEntity p);
}