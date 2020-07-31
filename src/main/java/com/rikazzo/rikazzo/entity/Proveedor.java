
package com.rikazzo.rikazzo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Proveedor{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proveedor;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private Integer ruc;

    @Column(nullable = false, length = 40)
    private String razonSoc;

    @Column(nullable = false, length = 50)
    private String direccion;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "prove")
    private List<Ropa> ropa = new ArrayList<>();


}
