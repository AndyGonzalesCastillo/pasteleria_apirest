package com.pasteleria.gestionPasteleria.service;

import java.util.List;
import com.pasteleria.gestionPasteleria.entity.CategoriaEntity;

public interface CategoriaService {
    public List<CategoriaEntity> findAll();

    public List<CategoriaEntity> findAllCustom();

    public CategoriaEntity findById(long id);

    public CategoriaEntity add(CategoriaEntity c);

    public CategoriaEntity update(CategoriaEntity c);

    public CategoriaEntity delete(CategoriaEntity c);
}