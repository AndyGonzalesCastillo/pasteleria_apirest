package com.pasteleria.gestionPasteleria.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pasteleria.gestionPasteleria.entity.EmpleadoEntity;
import com.pasteleria.gestionPasteleria.repository.EmpleadoRepository;
import com.pasteleria.gestionPasteleria.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repositorio;

    @Override
    public List<EmpleadoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<EmpleadoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public EmpleadoEntity findById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public EmpleadoEntity add(EmpleadoEntity e) {
        return repositorio.save(e);
    }

    @Override
    public EmpleadoEntity update(EmpleadoEntity e) {
        EmpleadoEntity objEmpleado = new EmpleadoEntity();
        BeanUtils.copyProperties(e, objEmpleado);
        return repositorio.save(objEmpleado);
    }

    @Override
    public EmpleadoEntity delete(EmpleadoEntity e) {
        EmpleadoEntity objEmpleado = repositorio.findById(e.getCodigo()).get();
        objEmpleado.setEstado(false);
        return repositorio.save(objEmpleado);

    }
}
