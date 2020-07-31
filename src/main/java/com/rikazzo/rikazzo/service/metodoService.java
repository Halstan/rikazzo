package com.rikazzo.rikazzo.service;

import com.rikazzo.rikazzo.entity.MetodoPago;
import com.rikazzo.rikazzo.repository.metodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class metodoService {

    private final metodoRepository metodoRepository;

    @Autowired
    public metodoService(metodoRepository metodoRepository) {
        this.metodoRepository = metodoRepository;
    }

    public List<MetodoPago> findAll(){
        return this.metodoRepository.findAll();
    }

    public MetodoPago addMetodo(MetodoPago metodoPago){
        return this.metodoRepository.save(metodoPago);
    }

    public MetodoPago findMetodo(Integer id){
        return this.metodoRepository.findById(id).get();
    }

    public MetodoPago updateMetodo(MetodoPago metodoPago){
        return this.metodoRepository.save(metodoPago);
    }

    public void deleteMetodo(Integer id){
        this.metodoRepository.deleteById(id);
    }
}