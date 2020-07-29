package com.rikazzo.rikazzo.service;

import com.rikazzo.rikazzo.entity.ModeloRopa;
import com.rikazzo.rikazzo.repository.modeloRopaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class modeloRopaService {

    private final modeloRopaRepository modeloRopaRepository;

    @Autowired
    public modeloRopaService(modeloRopaRepository modeloRopaRepository) {
        this.modeloRopaRepository = modeloRopaRepository;
    }

    public List<ModeloRopa> findAll(){
        return this.modeloRopaRepository.findAll();
    }

    public ModeloRopa addModelo(ModeloRopa modeloRopa){
        return this.modeloRopaRepository.save(modeloRopa);
    }

    public ModeloRopa updateModelo(ModeloRopa modeloRopa){
        return this.modeloRopaRepository.save(modeloRopa);
    }

    public ModeloRopa findById(Integer id){
        return this.modeloRopaRepository.findById(id).get();
    }

    public void deleteModelo(Integer id){
        this.modeloRopaRepository.deleteById(id);
    }
}
