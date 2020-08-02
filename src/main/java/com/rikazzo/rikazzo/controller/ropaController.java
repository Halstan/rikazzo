package com.rikazzo.rikazzo.controller;

import com.rikazzo.rikazzo.entity.Ropa;
import com.rikazzo.rikazzo.service.ropaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ropas")
public class ropaController {

    private final ropaService ropaService;

    @Autowired
    public ropaController(ropaService ropaService) {
        this.ropaService = ropaService;
    }

    @GetMapping(produces = "application/json")
    public List<Ropa> findAll(){
        return this.ropaService.findAll();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addRopa(@RequestBody Ropa ropa){

        Map<String, Object> resp = new HashMap<>();
        List<String> error = new ArrayList<>();

        if(ropa.getNombre().isEmpty()) error.add("El nombre no puede estar vacio");
        if(ropa.getPrecio() <= 0 || ropa.getPrecio() > 2000) error.add("Ingrese un precio mayor a y menor a 2000");
        if(ropa.getCantidad() <= 0) error.add("La cantidad no puede ser 0");

        try{
            if(error.isEmpty()){
                this.ropaService.addRopa(ropa);
                resp.put("message", ropa);
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

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateRopa(@RequestBody Ropa ropa){

        Map<String, Object> resp = new HashMap<>();
        List<String> error = new ArrayList<>();

        if(ropa.getNombre().isEmpty()) error.add("El nombre no puede estar vacio");
        if(ropa.getPrecio() <= 0 || ropa.getPrecio() > 2000) error.add("Ingrese un precio mayor a y menor a 2000");
        if(ropa.getCantidad() <= 0) error.add("La cantidad no puede ser 0");

        try{
            if(error.isEmpty()){
                this.ropaService.updateRopa(ropa);
                resp.put("message", ropa);
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

    @GetMapping("/{id}")
    public Ropa findRopa(@PathVariable Integer id){
        return this.ropaService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRopa(@PathVariable Integer id){
        this.ropaService.deleteRopa(id);
    }
}
