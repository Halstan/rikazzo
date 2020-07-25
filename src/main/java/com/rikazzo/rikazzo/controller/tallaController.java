package com.rikazzo.rikazzo.controller;

import com.rikazzo.rikazzo.entity.Talla;
import com.rikazzo.rikazzo.service.tallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/talla")
public class tallaController {

    private final tallaService tallaService;

    @Autowired
    public tallaController(com.rikazzo.rikazzo.service.tallaService tallaService) {
        this.tallaService = tallaService;
    }

    @GetMapping(produces = "application/json")
    public List<Talla> findAll(){
        return this.tallaService.findAll();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addTalla(@RequestBody Talla talla){
        Map<String, Object> resp = new HashMap<>();
        this.tallaService.addTalla(talla);
        resp.put("message", "La talla: " + talla.getTalla() + " ha sido creada");
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Talla findById(@PathVariable Long id){
        return this.tallaService.findTalla(id);
    }

    @PutMapping()
    public ResponseEntity<?> updateTalla(@RequestBody Talla talla){
        Map<String, Object> resp = new HashMap<>();
        this.tallaService.addTalla(talla);
        resp.put("message", "La talla: " + talla.getTalla() + " ha sido actualizada");
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.tallaService.deleteTalla(id);
    }
}
