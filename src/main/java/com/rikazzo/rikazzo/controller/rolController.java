package com.rikazzo.rikazzo.controller;

import com.rikazzo.rikazzo.entity.RoleVo;
import com.rikazzo.rikazzo.service.rolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class rolController {

    private final rolService rolService;

    @Autowired
    public rolController(rolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping(produces = "application/json")
    public List<RoleVo> findAll(){
        return this.rolService.findAll();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public RoleVo addRol(RoleVo roleVo){
        return this.rolService.addRol(roleVo);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public RoleVo findRol(@PathVariable Integer id){
        return this.rolService.findById(id);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public RoleVo updateRol(RoleVo roleVo){
        return this.rolService.updateRol(roleVo);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRol(@PathVariable Integer id){
        this.rolService.deleteRol(id);
    }
}
