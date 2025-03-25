package com.pasteleria.gestionPasteleria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.*;

//comentario de prueba
@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@Entity(name="CategoriaEntity") 
@Table(name="categoria")
public class CategoriaEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @Id 
    @Column(name="codcategoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name="nomcategoria")
    private String nombre;
    @Column(name="descripcioncategoria")
    private String descripcion;
    @Column(name="estado")
    private boolean estado;
}
