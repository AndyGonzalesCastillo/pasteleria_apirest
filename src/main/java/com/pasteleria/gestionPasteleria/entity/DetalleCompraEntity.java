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
import lombok.experimental.FieldDefaults;

@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name="DetalleCompraEntity") 
@Table(name="detalle_compra")
public class DetalleCompraEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @Id 
    @Column(name="coddetallecompra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;
    
    @ManyToOne
    @JoinColumn(name = "codcompra", nullable = false)
    CompraEntity compra;
    
    @ManyToOne
    @JoinColumn(name = "codinsumo", nullable = false)
    InsumoEntity insumo;
    
    @Column(name="cantidad")
    int cantidad;
    
    @Column(name="precio_unitario")
    double precioUnitario;
    
    @Column(name="subtotal")
    double subtotal;
}
