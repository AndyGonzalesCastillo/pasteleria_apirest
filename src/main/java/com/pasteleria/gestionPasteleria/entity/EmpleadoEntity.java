package com.pasteleria.gestionPasteleria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
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
@Entity(name = "EmpleadoEntity")
@Table(name = "empleado")
public class EmpleadoEntity implements Serializable  {
    
    private static final long serialVersionUID=1L;

    @Id 
    @Column(name="codempleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;
    
    @Column(name="nomempleado")
    String nombre;
    
    @Column(name="apeempleado")
    String apellido;
    
    @Column(name="dirempleado")
    String direccion;
    
    @Column(name="correoempleado")
    String correo;
    
    @Column(name="telefonoempleado")
    String telefono;
    
    @Column(name="puesto")
    String puesto;
    
    @Column(name="fecha_contratacion")
    Date fechaContratacion;
    
    @Column(name="estado")
    boolean estado;
}
