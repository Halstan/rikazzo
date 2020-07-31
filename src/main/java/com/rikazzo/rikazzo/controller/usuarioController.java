package com.rikazzo.rikazzo.controller;

import com.rikazzo.rikazzo.entity.RoleVo;
import com.rikazzo.rikazzo.entity.Usuario;
import com.rikazzo.rikazzo.service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
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
    public Usuario addUser(@RequestBody Usuario usuario){

        Set<RoleVo> newList = new HashSet();

        RoleVo role=new RoleVo();
        role.setId_role(1);
        role.setType("USUARIO");

        newList.add(role);

        usuario.setRol(newList);

        return this.usuarioService.addUser(usuario);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Usuario getUsuario(@PathVariable Integer id){
        return this.usuarioService.findById(id);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public Usuario updateUser(@RequestBody Usuario usuario){
        return this.usuarioService.updateUser(usuario);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Integer id){
        this.usuarioService.deleteUser(id);
    }

}
