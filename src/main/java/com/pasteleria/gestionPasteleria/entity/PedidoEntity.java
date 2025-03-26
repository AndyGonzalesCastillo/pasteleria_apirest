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
import java.util.Date; 
import lombok.experimental.FieldDefaults;

@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name="PedidoEntity") 
@Table(name="pedido")
public class PedidoEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @Id 
    @Column(name="codpedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;
    
    @ManyToOne
    @JoinColumn(name = "codcliente", nullable = false)
    ClienteEntity cliente;
    
    @ManyToOne
    @JoinColumn(name = "codempleado", nullable = false)
    EmpleadoEntity empleado;
    
    @Column(name="fecha_pedido")
    Date fechaPedido;
    
    @Column(name="fecha_entrega")
    Date fechaEntrega;
    
    @Column(name="tipo_entrega")
    String tipoEntrega;
    
    @Column(name="direccion_entrega")
    String direccion;
    
    @Column(name="estado_pedido")
    String estadoPedido;
    @Column(name="total")
    double total;
    
    @Column(name="observaciones")
    String observaciones;
    @Column(name="estado")
    boolean estado;
}
