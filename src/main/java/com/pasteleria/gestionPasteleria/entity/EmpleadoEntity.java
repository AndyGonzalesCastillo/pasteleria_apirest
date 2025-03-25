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
@Entity(name = "EmpleadoEntity")
@Table(name = "empleado")
public class EmpleadoEntity implements Serializable  {
    private static final long serialVersionUID=1L;

    @Id 
    @Column(name="codempleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name="nomempleado")
    private String nombre;
    @Column(name="apeempleado")
    private String apellido;
    @Column(name="dirempleado")
    private String direccion;
    @Column(name="correoempleado")
    private String correo;
    @Column(name="telefonoempleado")
    private String telefono;
    @Column(name="puesto")
    private String puesto;
    @Column(name="fecha_contratacion")
    private Date fechaContratacion;
    @Column(name="estado")
    private boolean estado;
}
