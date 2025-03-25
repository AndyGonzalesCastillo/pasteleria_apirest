package com.pasteleria.gestionPasteleria.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pasteleria.gestionPasteleria.entity.ProveedorEntity;
import com.pasteleria.gestionPasteleria.repository.ProveedorRepository;
import com.pasteleria.gestionPasteleria.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository repositorio;

    @Override
    public List<ProveedorEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<ProveedorEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public ProveedorEntity findById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public ProveedorEntity add(ProveedorEntity p) {
        return repositorio.save(p);
    }

    @Override
    public ProveedorEntity update(ProveedorEntity p) {
        ProveedorEntity objProveedor = new ProveedorEntity();
        BeanUtils.copyProperties(p, objProveedor);
        return repositorio.save(objProveedor);
    }

    @Override
    public ProveedorEntity delete(ProveedorEntity p) {
        ProveedorEntity objProveedor = repositorio.findById(p.getCodigo()).get();
        objProveedor.setEstado(false);
        return repositorio.save(objProveedor);

    }
}
