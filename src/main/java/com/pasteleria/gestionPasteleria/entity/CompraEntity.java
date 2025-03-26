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
import lombok.experimental.FieldDefaults;

@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name="CompraEntity") 
@Table(name="compra")
public class CompraEntity implements Serializable {
    
    private static final long serialVersionUID=1L;

    @Id 
    @Column(name="codcompra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;

    @ManyToOne
    @JoinColumn(name = "codproveedor", nullable = false)
    ProveedorEntity proveedor;
    
    @ManyToOne
    @JoinColumn(name = "codempleado", nullable = false)
    ProveedorEntity empleado;
    
    @Column(name="fechacompra")
    Date fechaCompra;
    
    @Column(name="totalcompra")
    double totalCompra;
    
    @Column(name="estado")
    boolean estado;
}
