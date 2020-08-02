
package com.rikazzo.rikazzo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Venta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_venta;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties("vent")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_ropa")
    @JsonIgnoreProperties("vent")
    private Ropa ropa;
    
    @Column(nullable = false)
    private Integer cantidad;

    @Column
    private Double precio_bruto;

    @Column
    private Double precio_total;

    private Date dateRegist;

    @ManyToOne
    @JsonIgnoreProperties("venta")
    private MetodoPago meto;
    
    @Column
    private String state;

    @PrePersist
    public void prePersist(){
        state = VentaState.ACTIVA.name();
        dateRegist = new Date();
    }

}
