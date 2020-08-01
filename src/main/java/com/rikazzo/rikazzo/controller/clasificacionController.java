package com.rikazzo.rikazzo.controller;

import com.rikazzo.rikazzo.entity.Clasificacion;
import com.rikazzo.rikazzo.service.clasificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clasificaciones")
public class clasificacionController {

    private final clasificacionService clasificacionService;

    @Autowired
    public clasificacionController(clasificacionService clasificacionService) {
        this.clasificacionService = clasificacionService;
    }

    @GetMapping(produces = "application/json")
    public List<Clasificacion> findAll(){
        return this.clasificacionService.findAll();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public Clasificacion addClasificacion(@RequestBody Clasificacion clasificacion){
        return this.clasificacionService.addClasificacion(clasificacion);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Clasificacion findById(@PathVariable Integer id){
        return this.clasificacionService.findClasificacion(id);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public Clasificacion updateMetodo(@RequestBody Clasificacion clasificacion){
        return this.clasificacionService.updateClasificacion(clasificacion);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deleteMetodo(@PathVariable Integer id){
        this.clasificacionService.deleteClasificacion(id);
    }
}