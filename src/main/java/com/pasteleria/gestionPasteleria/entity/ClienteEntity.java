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

@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@Entity(name="ClienteEntity") 
@Table(name="cliente")
public class ClienteEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @Id 
    @Column(name="codcliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name="nomcliente")
    private String nombre;
    @Column(name="apecliente")
    private String apellido;
    @Column(name="dircliente")
    private String direccion;
    @Column(name="correocliente")
    private String correo;
    @Column(name="telefonocliente")
    private String telefono;
    @Column(name="estado")
    private boolean estado;
}
