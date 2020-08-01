package com.rikazzo.rikazzo.controller;

import com.rikazzo.rikazzo.entity.ModeloRopa;
import com.rikazzo.rikazzo.service.modeloRopaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
public class modeloRopaController {

    private final modeloRopaService modeloRopaService;

    @Autowired
    public modeloRopaController(modeloRopaService modeloRopaService) {
        this.modeloRopaService = modeloRopaService;
    }

    @GetMapping(produces = "application/json")
    public List<ModeloRopa> findAll(){
        return this.modeloRopaService.findAll();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ModeloRopa addModelo(@RequestBody ModeloRopa modeloRopa){
        return this.modeloRopaService.addModelo(modeloRopa);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ModeloRopa updateModelo(@RequestBody ModeloRopa modeloRopa){
        return this.modeloRopaService.updateModelo(modeloRopa);
    }

    @GetMapping("/{id}")
    public ModeloRopa findModelo(@PathVariable Integer id){
        return this.modeloRopaService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteModelo(@PathVariable Integer id){
        this.modeloRopaService.deleteModelo(id);
    }

}
