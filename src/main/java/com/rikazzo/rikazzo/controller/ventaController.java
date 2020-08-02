package com.rikazzo.rikazzo.controller;

import com.rikazzo.rikazzo.entity.Venta;
import com.rikazzo.rikazzo.service.ventaService;
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
@RequestMapping("/api/ventas")
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
    public ResponseEntity<?> addVenta(@RequestBody Venta venta){

        Map<String, Object> resp = new HashMap<>();
        List<String> error = new ArrayList<>();

        if(venta.getCantidad() <= 0) error.add("Ingrese una cantidad");

        try{
            if(error.isEmpty()){
                this.ventaService.makeVenta(venta.getCantidad(), venta.getRopa().getId_prenda());
                double precioTotal = venta.getPrecio_bruto() * 0.14 + venta.getPrecio_bruto();
                venta.setPrecio_total(precioTotal);
                this.ventaService.addVenta(venta);

                resp.put("message", venta);
            }
        }catch (DataAccessException exception){
            resp.put("error message", "Error al registrar");
            resp.put("errors", error);
            return new ResponseEntity<>(resp, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
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
