package com.rikazzo.rikazzo.service;

import com.rikazzo.rikazzo.entity.RoleVo;
import com.rikazzo.rikazzo.exception.apiRequestException;
import com.rikazzo.rikazzo.repository.rolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class rolService {

    private final rolRepository rolRepository;

    @Autowired
    public rolService(rolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<RoleVo> findAll(){
        return this.rolRepository.findAll();
    }

    public RoleVo addRol(RoleVo roleVo){
        return this.rolRepository.save(roleVo);
    }

    public RoleVo updateRol(RoleVo roleVo){
        return this.rolRepository.save(roleVo);
    }

    public RoleVo findById(Integer id){
        return this.rolRepository.findById(id).orElseThrow(() -> new apiRequestException("Este rol no existe"));
    }

    public void deleteRol(Integer id){
        this.rolRepository.deleteById(id);
    }
}
