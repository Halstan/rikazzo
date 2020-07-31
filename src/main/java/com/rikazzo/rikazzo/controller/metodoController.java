package com.rikazzo.rikazzo.controller;

import com.rikazzo.rikazzo.entity.MetodoPago;
import com.rikazzo.rikazzo.service.metodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metodos")
public class metodoController {

    private final metodoService metodoService;

    @Autowired
    public metodoController(metodoService metodoService) {
        this.metodoService = metodoService;
    }

    @GetMapping(produces = "application/json")
    public List<MetodoPago> findAll(){
        return this.metodoService.findAll();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public MetodoPago addMetodo(@RequestBody MetodoPago metodoPago){
        return this.metodoService.addMetodo(metodoPago);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public MetodoPago updateMetodo(@RequestBody MetodoPago metodoPago){
        return this.metodoService.updateMetodo(metodoPago);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public MetodoPago findMetodo(@PathVariable Integer id){
        return this.metodoService.findMetodo(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMetodo(@PathVariable Integer id){
        this.metodoService.deleteMetodo(id);
    }
}
