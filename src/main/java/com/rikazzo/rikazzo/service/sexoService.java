package com.rikazzo.rikazzo.service;

import com.rikazzo.rikazzo.entity.Sexo;
import com.rikazzo.rikazzo.exception.apiRequestException;
import com.rikazzo.rikazzo.repository.sexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class sexoService {

    private final sexoRepository sexoRepository;

    @Autowired
    public sexoService(sexoRepository sexoRepository) {
        this.sexoRepository = sexoRepository;
    }

    public List<Sexo> findAll(){
        return this.sexoRepository.findAll();
    }

    public Sexo addSexo(Sexo sexo){
        return this.sexoRepository.save(sexo);
    }

    public Sexo findById(Long id){
        return this.sexoRepository.findById(id).orElseThrow(() -> new apiRequestException("Este sexo no existe"));
    }

    public Sexo updateSexo(Sexo sexo){
        return this.sexoRepository.save(sexo);
    }

    public void deleteSexo(Long id){
        this.sexoRepository.deleteById(id);
    }
}
