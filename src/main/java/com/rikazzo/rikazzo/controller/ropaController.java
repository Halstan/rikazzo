package com.rikazzo.rikazzo.controller;

import com.rikazzo.rikazzo.entity.Ropa;
import com.rikazzo.rikazzo.service.ropaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ropas")
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
    public Ropa addRopa(@RequestBody Ropa ropa){
        return this.ropaService.addRopa(ropa);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public Ropa updateRopa(@RequestBody Ropa ropa){
        return this.ropaService.updateRopa(ropa);
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
