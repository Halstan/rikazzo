
package com.rikazzo.rikazzo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Ropa{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_prenda;
    
    @Column(length = 40, nullable = false)
    private String nombre;

    @Column
    private Double precio;

    private Integer cantidad;

    @ManyToOne
    @JsonIgnoreProperties("ropa")
    private Talla talla;
    
    @ManyToOne
    @JsonIgnoreProperties("ropa")
    private Clasificacion clasi;
    
    @ManyToOne
    @JsonIgnoreProperties("ropa")
    private Proveedor prove;
    
    @ManyToOne
    @JsonIgnoreProperties("ropa")
    private ModeloRopa modelo;
    
    @OneToMany(mappedBy = "ropa", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("ropa")
    private List<Venta> vent = new ArrayList<>();
    
}
