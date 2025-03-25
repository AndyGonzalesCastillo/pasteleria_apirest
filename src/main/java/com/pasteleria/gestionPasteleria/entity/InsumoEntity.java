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
@Entity(name="InsumoEntity") 
@Table(name="insumo")
public class InsumoEntity implements Serializable {

    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codinsumo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
    @Column(name="nominsumo")
    private String nombre;
    @Column(name="descripcioninsumo")
    private String descripcion;
    @Column(name="unidad_medida")
    private String unidadMedida;
    @Column(name="stock_actual")
    private double stockActual;
    @Column(name="stock_minimo")
    private double stockMinimo;
    @Column(name="estado")
    private boolean estado;
}
