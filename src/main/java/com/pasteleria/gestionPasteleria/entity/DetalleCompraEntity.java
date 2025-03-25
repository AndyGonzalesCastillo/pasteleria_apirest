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
@Entity(name="DetalleCompraEntity") 
@Table(name="detalle_compra")
public class DetalleCompraEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @Id 
    @Column(name="coddetallecompra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @ManyToOne
    @JoinColumn(name = "codcompra", nullable = false)
    private CompraEntity compra;
    @ManyToOne
    @JoinColumn(name = "codinsumo", nullable = false)
    private InsumoEntity insumo;
    @Column(name="cantidad")
    private int cantidad;
    @Column(name="precio_unitario")
    private double precioUnitario;
    @Column(name="subtotal")
    private double subtotal;
}
