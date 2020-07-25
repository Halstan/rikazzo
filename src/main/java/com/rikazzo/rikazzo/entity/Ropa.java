
package com.rikazzo.rikazzo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
    
    @ManyToOne
    private Talla talla;
    
    @ManyToOne
    private Clasificacion clasi;
    
    @ManyToOne
    private Proveedor prove;
    
    @ManyToOne
    private ModeloRopa modelo;
    
    @OneToMany(mappedBy = "ropa", fetch = FetchType.EAGER)
    private List<Venta> vent = new ArrayList<>();
    
}
