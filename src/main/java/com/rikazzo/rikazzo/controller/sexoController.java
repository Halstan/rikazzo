package com.rikazzo.rikazzo.controller;

import com.rikazzo.rikazzo.entity.Sexo;
import com.rikazzo.rikazzo.service.sexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sexo")
public class sexoController {

    private final sexoService sexoService;

    @Autowired
    public sexoController(sexoService sexoService) {
        this.sexoService = sexoService;
    }

    @GetMapping(produces = "application/json")
    public List<Sexo> getAll(){
        return this.sexoService.findAll();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addSexo(@RequestBody Sexo sexo){
        Map<String, Object> resp = new HashMap<>();
        this.sexoService.addSexo(sexo);
        resp.put("message", "El sexo: " + sexo.getSexo() + " ha sido creado");
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}" ,produces = "application/json")
    public Sexo findById(@PathVariable Long id) {
        return this.sexoService.findById(id);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> updateSexo(@RequestBody Sexo sexo) {
        Map<String, Object> resp = new HashMap<>();
        this.sexoService.addSexo(sexo);
        resp.put("message", "El sexo: " + sexo.getSexo() + " ha sido actualizado");
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public void deleteSexo(@PathVariable Long id){
        this.sexoService.deleteSexo(id);
    }
}
