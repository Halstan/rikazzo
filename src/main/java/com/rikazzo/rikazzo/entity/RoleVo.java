
package com.rikazzo.rikazzo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "role")
public class RoleVo{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_role;

    @Column(unique = true, nullable = false)
    private String type= RoleType.USUARIO.name();

    //LADO INVERSE
    @ManyToMany(mappedBy = "rol", fetch = FetchType.EAGER)
    private Set<Usuario> user = new HashSet<>();
}
