
package com.rikazzo.rikazzo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role")
public class RoleVo{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_role;

    @Column(unique = true, nullable = false)
    private String type= RoleType.USUARIO.name();

    //LADO INVERSE
    @ManyToMany(mappedBy = "rol", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("rol")
    private Set<Usuario> user = new HashSet<>();

    public RoleVo() {

    }

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Usuario> getUser() {
        return user;
    }

    public void setUser(Set<Usuario> user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleVo)) return false;
        RoleVo roleVo = (RoleVo) o;
        return Objects.equals(id_role, roleVo.id_role) &&
                Objects.equals(type, roleVo.type) &&
                Objects.equals(user, roleVo.user);
    }

}
