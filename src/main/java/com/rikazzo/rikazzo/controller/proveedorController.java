package com.rikazzo.rikazzo.controller;

import com.rikazzo.rikazzo.entity.Proveedor;
import com.rikazzo.rikazzo.service.proveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class proveedorController {

    private final proveedorService proveedorService;

    @Autowired
    public proveedorController(proveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping(produces = "application/json")
    public List<Proveedor> findAll(){
        return this.proveedorService.findAll();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public Proveedor addProveedor(@RequestBody Proveedor proveedor){
        return this.proveedorService.addProveedor(proveedor);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Proveedor findById(@PathVariable(value = "id") Integer id){
        return this.proveedorService.findById(id);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public Proveedor updateProveedor(@RequestBody Proveedor proveedor){
        return this.proveedorService.updateProveedor(proveedor);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deleteProveedor(@PathVariable Integer id){
        this.proveedorService.deleteProveedor(id);
    }

}
