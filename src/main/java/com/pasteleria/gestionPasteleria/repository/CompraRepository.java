package com.pasteleria.gestionPasteleria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pasteleria.gestionPasteleria.entity.CompraEntity;
import com.pasteleria.gestionPasteleria.entity.ProductoEntity;

public interface CompraRepository extends JpaRepository<CompraEntity, Long> {

    @Query("select c from CompraEntity c where c.estado=true")
    List<CompraEntity> findAllCustom();
}