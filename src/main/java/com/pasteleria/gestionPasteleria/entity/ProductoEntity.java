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
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@Entity(name="ProductoEntity") 
@Table(name="producto")
public class ProductoEntity implements Serializable  {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codproducto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
   
    @ManyToOne
    @JoinColumn(name = "codcategoria", nullable = false)
    private CategoriaEntity categoria;

    @Column(name="nomproducto")
    private String nombre;
    @Column(name="descripcionproducto")
    private String descripcion;
    @Column(name="precio")
    private double precio;
    @Column(name="tiempo_preparacion")
    private int tiempoPreparacion;
    @Column(name="stock")
    private int stock;
    @Column(name="estado")
    private boolean estado;
    
}