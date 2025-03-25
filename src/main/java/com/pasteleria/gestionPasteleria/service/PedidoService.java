package com.pasteleria.gestionPasteleria.service;

import java.util.List;
import com.pasteleria.gestionPasteleria.entity.PedidoEntity;

public interface PedidoService {
    public List<PedidoEntity> findAll();

    public List<PedidoEntity> findAllCustom();

    public PedidoEntity findById(long id);

    public PedidoEntity add(PedidoEntity p);

    public PedidoEntity update(PedidoEntity p);

    public PedidoEntity delete(PedidoEntity p);
}