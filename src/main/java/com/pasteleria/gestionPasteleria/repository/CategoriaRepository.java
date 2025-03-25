package com.pasteleria.gestionPasteleria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pasteleria.gestionPasteleria.entity.CategoriaEntity;

public interface CategoriaRepository extends  JpaRepository<CategoriaEntity, Long>{
    @Query("select c from CategoriaEntity c where c.estado=true")
    List<CategoriaEntity> findAllCustom();
    
}

