package com.pasteleria.gestionPasteleria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity(name="ProveedorEntity") 
@Table(name="proveedor")
public class ProveedorEntity implements Serializable  {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codproveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;
    
    @Column(name="nomproveedor")
    String nombre;
    
    @Column(name="dirproveedor")
    String direccion;
    
    @Column(name="correoproveedor")
    String correo;
    
    @Column(name="telefonoproveedor")
    String telefono;
    
    @Column(name="estado")
    boolean estado;
    
}