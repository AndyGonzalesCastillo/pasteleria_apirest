package com.pasteleria.gestionPasteleria.service;

import java.util.List;
import com.pasteleria.gestionPasteleria.entity.ProductoEntity;

public interface ProductoService {
    public List<ProductoEntity> findAll();

    public List<ProductoEntity> findAllCustom();

    public ProductoEntity findById(long id);

    public ProductoEntity add(ProductoEntity p);

    public ProductoEntity update(ProductoEntity p);

    public ProductoEntity delete(ProductoEntity p);
}