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
@Entity(name="DetallePedidoEntity") 
@Table(name="detalle_pedido")
public class DetallePedidoEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @Id 
    @Column(name="coddetallepedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @ManyToOne
    @JoinColumn(name = "codpedido", nullable = false)
    private PedidoEntity pedido;
    @ManyToOne
    @JoinColumn(name = "codproducto", nullable = false)
    private ProductoEntity producto;
    @Column(name="cantidad")
    private int cantidad;
    @Column(name="precio_unitario")
    private double precioUnitario;
    @Column(name="subtotal")
    private double subtotal;
    @Column(name="especificaciones")
    private String especificaciones;
}
