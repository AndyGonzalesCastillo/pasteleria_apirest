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
@Entity(name="DetallePedidoEntity") 
@Table(name="detalle_pedido")
public class DetallePedidoEntity implements Serializable {
   
    private static final long serialVersionUID=1L;

    @Id 
    @Column(name="coddetallepedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;
    
    @ManyToOne
    @JoinColumn(name = "codpedido", nullable = false)
    PedidoEntity pedido;
    
    @ManyToOne
    @JoinColumn(name = "codproducto", nullable = false)
    ProductoEntity producto;
    
    @Column(name="cantidad")
    int cantidad;
    
    @Column(name="precio_unitario")
    double precioUnitario;
    
    @Column(name="subtotal")
    double subtotal;
    
    @Column(name="especificaciones")
    String especificaciones;
}
