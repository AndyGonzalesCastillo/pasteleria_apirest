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
@Entity(name="InsumoEntity") 
@Table(name="insumo")
public class InsumoEntity implements Serializable {

    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codinsumo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;
    
    @Column(name="nominsumo")
    String nombre;
    
    @Column(name="descripcioninsumo")
    String descripcion;
    
    @Column(name="unidad_medida")
    String unidadMedida;
    
    @Column(name="stock_actual")
    double stockActual;
    
    @Column(name="stock_minimo")
    double stockMinimo;
    
    @Column(name="estado")
    boolean estado;
}
