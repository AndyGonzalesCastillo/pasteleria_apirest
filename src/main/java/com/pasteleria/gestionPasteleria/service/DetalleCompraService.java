package com.pasteleria.gestionPasteleria.service;

import java.util.List;
import com.pasteleria.gestionPasteleria.entity.DetalleCompraEntity;

public interface DetalleCompraService {
    public List<DetalleCompraEntity> findAll();

    public DetalleCompraEntity findById(long id);

    public DetalleCompraEntity add(DetalleCompraEntity d);

    public DetalleCompraEntity update(DetalleCompraEntity d);
}