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
@Entity(name="ProveedorEntity") 
@Table(name="proveedor")
public class ProveedorEntity implements Serializable  {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codproveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
    @Column(name="nomproveedor")
    private String nombre;
    @Column(name="dirproveedor")
    private String direccion;
    @Column(name="correoproveedor")
    private String correo;
    @Column(name="telefonoproveedor")
    private String telefono;
    @Column(name="estado")
    private boolean estado;
    
}