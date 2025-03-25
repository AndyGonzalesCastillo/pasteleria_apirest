package com.pasteleria.gestionPasteleria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pasteleria.gestionPasteleria.entity.DetalleCompraEntity;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompraEntity, Long> {

}