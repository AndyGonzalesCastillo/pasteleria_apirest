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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name="ProductoEntity") 
@Table(name="producto")
public class ProductoEntity implements Serializable  {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codproducto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;
    
    @ManyToOne
    @JoinColumn(name = "codcategoria", nullable = false)
    CategoriaEntity categoria;

    @Column(name="nomproducto")
    String nombre;
    
    @Column(name="descripcionproducto")
    String descripcion;
    
    @Column(name="precio")
    double precio;
    
    @Column(name="tiempo_preparacion")
    int tiempoPreparacion;
    
    @Column(name="stock")
    int stock;
    
    @Column(name="estado")
    boolean estado;
}