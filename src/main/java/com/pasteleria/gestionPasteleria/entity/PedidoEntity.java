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

@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@Entity(name="PedidoEntity") 
@Table(name="pedido")
public class PedidoEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @Id 
    @Column(name="codpedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @ManyToOne
    @JoinColumn(name = "codcliente", nullable = false)
    private ClienteEntity cliente;
    @ManyToOne
    @JoinColumn(name = "codempleado", nullable = false)
    private EmpleadoEntity empleado;
    @Column(name="fecha_pedido")
    private Date fechaPedido;
    @Column(name="fecha_entrega")
    private Date fechaEntrega;
    @Column(name="tipo_entrega")
    private String tipoEntrega;
    @Column(name="direccion_entrega")
    private String direccion;
    
    @Column(name="estado_pedido")
    private String estadoPedido;
    @Column(name="total")
    private double total;
    
    @Column(name="observaciones")
    private String observaciones;
    @Column(name="estado")
    private boolean estado;
}
