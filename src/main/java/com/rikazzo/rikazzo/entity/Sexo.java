
package com.rikazzo.rikazzo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Sexo{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sexo;

    @Column(nullable = false, length = 12)
    private String sexo;
    
    @OneToMany (mappedBy = "sexo")
    private List<Usuario> cli = new ArrayList<>();

}
