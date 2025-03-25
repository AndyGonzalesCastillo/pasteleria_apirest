package com.pasteleria.gestionPasteleria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pasteleria.gestionPasteleria.entity.InsumoEntity;

public interface InsumoRepository extends JpaRepository<InsumoEntity, Long> {

    @Query("select i from InsumoEntity i where i.estado=true")
    List<InsumoEntity> findAllCustom();
}