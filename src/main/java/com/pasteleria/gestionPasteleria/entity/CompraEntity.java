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
import lombok.*; 

@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@Entity(name="CompraEntity") 
@Table(name="compra")
public class CompraEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @Id 
    @Column(name="codcompra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @ManyToOne
    @JoinColumn(name = "codproveedor", nullable = false)
    private ProveedorEntity proveedor;
    
    @ManyToOne
    @JoinColumn(name = "codempleado", nullable = false)
    private ProveedorEntity empleado;
    
    @Column(name="fechacompra")
    private Date fechaCompra;
    @Column(name="totalcompra")
    private double totalCompra;
    @Column(name="estado")
    private boolean estado;
}
