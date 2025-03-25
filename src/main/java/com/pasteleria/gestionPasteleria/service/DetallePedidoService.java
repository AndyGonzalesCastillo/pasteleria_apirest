package com.pasteleria.gestionPasteleria.service;

import java.util.List;
import com.pasteleria.gestionPasteleria.entity.DetallePedidoEntity;

public interface DetallePedidoService {
    public List<DetallePedidoEntity> findAll();

    public DetallePedidoEntity findById(long id);

    public DetallePedidoEntity add(DetallePedidoEntity d);

    public DetallePedidoEntity update(DetallePedidoEntity d);

}