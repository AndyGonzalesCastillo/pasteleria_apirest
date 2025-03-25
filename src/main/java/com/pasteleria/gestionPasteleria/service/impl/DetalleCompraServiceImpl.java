package com.pasteleria.gestionPasteleria.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pasteleria.gestionPasteleria.entity.CompraEntity;
import com.pasteleria.gestionPasteleria.entity.DetalleCompraEntity;
import com.pasteleria.gestionPasteleria.repository.CompraRepository;
import com.pasteleria.gestionPasteleria.repository.DetalleCompraRepository;
import com.pasteleria.gestionPasteleria.service.CompraService;
import com.pasteleria.gestionPasteleria.service.DetalleCompraService;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {

    @Autowired
    private DetalleCompraRepository repositorio;

    @Override
    public List<DetalleCompraEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public DetalleCompraEntity findById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public DetalleCompraEntity add(DetalleCompraEntity d) {
        return repositorio.save(d);
    }

    @Override
    public DetalleCompraEntity update(DetalleCompraEntity d) {
        DetalleCompraEntity objCompra = new DetalleCompraEntity();
        BeanUtils.copyProperties(d, objCompra);
        return repositorio.save(objCompra);
    }

}