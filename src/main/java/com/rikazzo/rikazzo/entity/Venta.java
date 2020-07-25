
package com.rikazzo.rikazzo.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Venta{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usua;
    
    @ManyToOne
    @JoinColumn(name = "id_ropa")
    private Ropa ropa;
    
    @Column(nullable = false)
    private Long cantidad;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    private Date fecha;

    @Column
    private Double precio_bruto;

    @Column
    private Double precio_total;

    @ManyToOne
    private MetodoPago meto;
    
    @Column
    private String state = VentaState.ACTIVA.name();


}
