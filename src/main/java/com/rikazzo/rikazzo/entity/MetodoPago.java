package com.rikazzo.rikazzo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class MetodoPago{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_metodo;

    @Column(length = 40)
    private String metodo;

    @OneToMany(mappedBy = "meto")
    @JsonIgnoreProperties("meto")
    private List<Venta> venta = new ArrayList<>();


}