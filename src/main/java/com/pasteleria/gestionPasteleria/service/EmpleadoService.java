package com.pasteleria.gestionPasteleria.service;

import java.util.List;
import com.pasteleria.gestionPasteleria.entity.EmpleadoEntity;

public interface EmpleadoService {
    public List<EmpleadoEntity> findAll();

    public List<EmpleadoEntity> findAllCustom();

    public EmpleadoEntity findById(long id);

    public EmpleadoEntity add(EmpleadoEntity e);

    public EmpleadoEntity update(EmpleadoEntity e);

    public EmpleadoEntity delete(EmpleadoEntity e);
}