package com.rikazzo.rikazzo.service;

import com.rikazzo.rikazzo.entity.Clasificacion;
import com.rikazzo.rikazzo.exception.apiRequestException;
import com.rikazzo.rikazzo.repository.clasificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class clasificacionService {

    private final clasificacionRepository clasificacionRepository;

    @Autowired
    public clasificacionService(clasificacionRepository clasificacionRepository) {
        this.clasificacionRepository = clasificacionRepository;
    }

    public List<Clasificacion> findAll(){
        return this.clasificacionRepository.findAll();
    }

    public Clasificacion addClasificacion(Clasificacion clasificacion){
        return this.clasificacionRepository.save(clasificacion);
    }

    public Clasificacion updateClasificacion(Clasificacion clasificacion){
        return this.clasificacionRepository.save(clasificacion);
    }

    public Clasificacion findClasificacion(Integer id){
        return this.clasificacionRepository.findById(id).orElseThrow(() -> new apiRequestException("Esta clasificacion no existe"));
    }

    public void deleteClasificacion(Integer id){
        this.clasificacionRepository.deleteById(id);
    }
}
