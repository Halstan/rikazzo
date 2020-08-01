package com.rikazzo.rikazzo.controller;

import com.rikazzo.rikazzo.entity.Venta;
import com.rikazzo.rikazzo.service.ventaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class ventaController {

    private final ventaService ventaService;

    @Autowired
    public ventaController(ventaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping(produces = "application/json")
    public List<Venta> findAll(){
        return this.ventaService.findAll();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Venta addVenta(@RequestBody Venta venta){
        this.ventaService.makeVenta(venta.getCantidad(), venta.getRopa().getId_prenda());
        return this.ventaService.addVenta(venta);
    }

    @GetMapping("/{id}")
    public Venta findVenta(@PathVariable Long id){
        return this.ventaService.findById(id);
    }

    @PutMapping("/{id}")
    public void desactivateVenta(@PathVariable Integer id){
        this.ventaService.desactivateVenta(id);
    }
}
