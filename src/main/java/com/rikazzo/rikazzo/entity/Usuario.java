
package com.rikazzo.rikazzo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.*;

@Entity
@Data
public class Usuario{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(nullable = false, length = 80)
    private String password;

    @Column
    private Integer dni;

    @Column(nullable = false, length = 40)
    private String nombre;

    @Column(nullable = false, length = 40)
    private String apellidoPaterno;

    @Column(length = 40)
    private String apellidoMaterno;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    private Date fecha_nacimiento;

    @Column
    private String celular;

    @Column(nullable = false, length = 100)
    @Email
    private String email;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegist;

    private Date dateUpdate;
    
    @ManyToOne
    @JsonIgnoreProperties("cli")
    private Sexo sexo;
    
    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private Collection<Venta> vent = new ArrayList<>();
    
    @Column
    @JsonIgnoreProperties
    private String state;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("user")
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario"),
                inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<RoleVo> rol = new HashSet<>();

    @PrePersist
    public void prePersist(){
        state = StateType.ACTIVE.name();
    }

    @PreUpdate
    protected void onUpdate() {
        dateUpdate = new Date();
    }

}
