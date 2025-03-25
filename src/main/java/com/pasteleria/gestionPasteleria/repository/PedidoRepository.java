package com.pasteleria.gestionPasteleria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pasteleria.gestionPasteleria.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    @Query("select p from PedidoEntity p where p.estado=true")
    List<PedidoEntity> findAllCustom();
}