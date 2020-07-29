package com.rikazzo.rikazzo.service;

import com.rikazzo.rikazzo.entity.Proveedor;
import com.rikazzo.rikazzo.repository.proveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class proveedorService {

    private final proveedorRepository proveedorRepository;

    @Autowired
    public proveedorService(proveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public List<Proveedor> findAll(){
        return this.proveedorRepository.findAll();
    }

    public Proveedor addProveedor(Proveedor proveedor){
        return this.proveedorRepository.save(proveedor);
    }

    public Proveedor updateProveedor(Proveedor proveedor){
        return this.proveedorRepository.save(proveedor);
    }

    public Proveedor findById(Integer id){
        return this.proveedorRepository.findById(id).get();
    }

    public void deleteProveedor(Integer id){
        this.proveedorRepository.deleteById(id);
    }

}
