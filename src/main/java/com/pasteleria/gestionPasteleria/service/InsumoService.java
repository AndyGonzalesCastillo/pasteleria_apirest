package com.pasteleria.gestionPasteleria.service;

import java.util.List;
import com.pasteleria.gestionPasteleria.entity.InsumoEntity;

public interface InsumoService {
    public List<InsumoEntity> findAll();

    public List<InsumoEntity> findAllCustom();

    public InsumoEntity findById(long id);

    public InsumoEntity add(InsumoEntity i);

    public InsumoEntity update(InsumoEntity i);

    public InsumoEntity delete(InsumoEntity i);
}