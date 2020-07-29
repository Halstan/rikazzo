package com.rikazzo.rikazzo.service;

import com.rikazzo.rikazzo.entity.Ropa;
import com.rikazzo.rikazzo.repository.ropaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ropaService {

    private final ropaRepository ropaRepository;

    @Autowired
    public ropaService(com.rikazzo.rikazzo.repository.ropaRepository ropaRepository) {
        this.ropaRepository = ropaRepository;
    }

    public List<Ropa> findAll(){
        return this.ropaRepository.findAll();
    }

    public Ropa addRopa(Ropa ropa){
        return this.ropaRepository.save(ropa);
    }

    public Ropa updateRopa(Ropa ropa){
        return this.ropaRepository.save(ropa);
    }

    public Ropa findById(Integer id){
        return this.ropaRepository.findById(id).get();
    }

    public void deleteRopa(Integer id){
        this.ropaRepository.deleteById(id);
    }
}
