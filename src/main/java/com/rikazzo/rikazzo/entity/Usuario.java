
package com.rikazzo.rikazzo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
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

    @Column(nullable = false)
    //@Text (value = Text.TextType.PASSWORD, message = "Ingrese contraseña")
    private String password;

    @Column
    private Integer dni;

    @Column(nullable = false, length = 40)
    //@Text (value = Text.TextType.LETTERS, message = "Ingrese nombre")
    private String nombre;

    @Column(nullable = false, length = 40)
    //@Text (value = Text.TextType.LETTERS, message = "Ingrese apellido paterno")
    private String apellidoPaterno;

    //@Text (value = Text.TextType.LETTERS, message = "Ingrese apellido materno")
    @Column(length = 40)
    private String apellidoMaterno;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    private Date fecha_nacimiento;

    @Column
    private Integer celular;

    @Column(nullable = false, unique = true, length = 100)
    @Email
    private String email;
    
    @ManyToOne
    @JsonIgnoreProperties("cli")
    private Sexo sexo;
    
    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private Collection<Venta> vent = new ArrayList<>();
    
    @Column
    @JsonIgnoreProperties
    private String state = StateType.ACTIVE.name();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("user")
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario"),
                inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<RoleVo> rol = new HashSet<>();


}
