package com.pasteleria.gestionPasteleria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name="CategoriaEntity") 
@Table(name="categoria")
public class CategoriaEntity implements Serializable {
    
    private static final long serialVersionUID=1L;

    @Id 
    @Column(name="codcategoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;
    
    @Column(name="nomcategoria")
    String nombre;
    
    @Column(name="descripcioncategoria")
    String descripcion;
    
    @Column(name="estado")
    boolean estado;
}
