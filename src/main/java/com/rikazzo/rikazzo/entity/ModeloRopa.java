
package com.rikazzo.rikazzo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class ModeloRopa{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_modelo;

    @Column(length = 40)
    private String nombre;

    @OneToMany(mappedBy = "modelo")
    private List<Ropa> ropa = new ArrayList<>();

}
