package com.pasteleria.gestionPasteleria.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pasteleria.gestionPasteleria.entity.ClienteEntity;
import com.pasteleria.gestionPasteleria.entity.CompraEntity;
import com.pasteleria.gestionPasteleria.repository.ClienteRepository;
import com.pasteleria.gestionPasteleria.repository.CompraRepository;
import com.pasteleria.gestionPasteleria.service.ClienteService;
import com.pasteleria.gestionPasteleria.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository repositorio;

    @Override
    public List<CompraEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<CompraEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public CompraEntity findById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public CompraEntity add(CompraEntity c) {
        return repositorio.save(c);
    }

    @Override
    public CompraEntity update(CompraEntity c) {
        CompraEntity objCompra = new CompraEntity();
        BeanUtils.copyProperties(c, objCompra);
        return repositorio.save(objCompra);
    }

    @Override
    public CompraEntity delete(CompraEntity c) {
        CompraEntity objCompra = repositorio.findById(c.getCodigo()).get();
        objCompra.setEstado(false);
        return repositorio.save(objCompra);

    }
}