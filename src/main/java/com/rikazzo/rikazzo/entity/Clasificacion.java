
package com.rikazzo.rikazzo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Clasificacion{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_sexoR;

    @Column(length = 12)
    private String sexo;
    
    @OneToMany(mappedBy = "clasi")
    private List<Ropa> ropa = new ArrayList<>();
    
}
