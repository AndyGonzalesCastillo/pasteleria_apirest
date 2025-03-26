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
@Entity(name="ClienteEntity") 
@Table(name="cliente")
public class ClienteEntity implements Serializable {
    
    private static final long serialVersionUID=1L;

    @Id 
    @Column(name="codcliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;
    
    @Column(name="nomcliente")
    String nombre;
    
    @Column(name="apecliente")
    String apellido;
    
    @Column(name="dircliente")
    String direccion;
    
    @Column(name="correocliente")
    String correo;
    
    @Column(name="telefonocliente")
    String telefono;
    
    @Column(name="estado")
    boolean estado;
}
