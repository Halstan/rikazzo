package com.rikazzo.rikazzo.controller;

import com.rikazzo.rikazzo.entity.RoleVo;
import com.rikazzo.rikazzo.entity.Usuario;
import com.rikazzo.rikazzo.service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/usuarios")
public class usuarioController {

    private final usuarioService usuarioService;

    @Autowired
    public usuarioController(usuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(produces = "application/json")
    public List<Usuario> findAll(){
        return this.usuarioService.findAll();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addUser(@RequestBody Usuario usuario){
        return getResponseEntity(usuario);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Usuario getUsuario(@PathVariable Integer id){
        return this.usuarioService.findById(id);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateUser(@RequestBody Usuario usuario){
        return getResponseEntity(usuario);
    }

    private ResponseEntity<?> getResponseEntity(@RequestBody Usuario usuario) {
        Map<String, Object> resp = new HashMap<>();
        List<String> error = new ArrayList<>();

        if(usuario.getNombre().isEmpty()){ error.add("El nombre no puede estar vacío"); }
        if (usuario.getApellidoPaterno().isEmpty()) { error.add("El apellido paterno no puede estar vacio"); }
        if (usuario.getPassword().isEmpty()) { error.add("La contraseña no puede estar vacia"); }
        if (usuario.getEmail().isEmpty()){ error.add("El correo no puede estar vacio"); }
        if(usuario.getCelular().isEmpty() || usuario.getCelular().length() > 9){ error.add("El celular no puede estar vacio ni menor a 9 digitos"); }

        try{
            if(error.isEmpty()){

                Set<RoleVo> newList = new HashSet();
                RoleVo role=new RoleVo();
                role.setId_role(3);
                role.setType("USUARIO");
                newList.add(role);
                usuario.setRol(newList);

                this.usuarioService.addUser(usuario);

                resp.put("message", usuario);
            }else{
                resp.put("error message", error);
            }
        }catch (DataAccessException exception){
            resp.put("error message", "Error al registrar");
            resp.put("errors", error);
            return new ResponseEntity<>(resp, HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Integer id){
        this.usuarioService.deleteUser(id);
    }

}
