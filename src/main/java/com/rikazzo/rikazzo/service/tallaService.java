package com.rikazzo.rikazzo.service;

import com.rikazzo.rikazzo.entity.Talla;
import com.rikazzo.rikazzo.repository.tallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class tallaService {

    private final tallaRepository tallaRepository;

    @Autowired
    public tallaService(tallaRepository tallaRepository) {
        this.tallaRepository = tallaRepository;
    }

    public List<Talla> findAll(){
        return this.tallaRepository.findAll();
    }

    public Talla addTalla(Talla talla){
        return this.tallaRepository.save(talla);
    }

    public Talla findTalla(Long id){
        return this.tallaRepository.findById(id).get();
    }

    public Talla updateTalla(Talla talla){
        return this.tallaRepository.save(talla);
    }

    public void deleteTalla(Long id){
        this.tallaRepository.deleteById(id);
    }
}
