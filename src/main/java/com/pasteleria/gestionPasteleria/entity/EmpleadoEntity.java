package com.pasteleria.gestionPasteleria.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    Date fechaContratacion;
    
    @Column(name="estado")
    boolean estado;
}
