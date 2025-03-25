package com.pasteleria.gestionPasteleria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pasteleria.gestionPasteleria.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

    @Query("select p from ProductoEntity p where p.estado=true")
    List<ProductoEntity> findAllCustom();
}