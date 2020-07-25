package com.rikazzo.rikazzo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Talla{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_talla;

    @Column(length = 4)
    private String talla;
    
    @OneToMany(mappedBy = "talla")
    @JsonIgnoreProperties("talla")
    private List<Ropa> ropa = new ArrayList<>();


}