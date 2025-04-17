package com.pasteleria.gestionPasteleria.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date; 
import lombok.*; 
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

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
    EmpleadoEntity empleado;

    @Column(name="fechacompra")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    
    @Column(name="totalcompra")
    double totalCompra;
    
    @Column(name="estado")
    boolean estado;
}
