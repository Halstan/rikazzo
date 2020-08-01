package com.rikazzo.rikazzo.service;

import com.rikazzo.rikazzo.entity.Venta;
import com.rikazzo.rikazzo.exception.apiRequestException;
import com.rikazzo.rikazzo.repository.ventaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ventaService {

    private final ventaRepository ventaRepository;

    @Autowired
    public ventaService(ventaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> findAll(){
        return this.ventaRepository.findAll();
    }

    public Venta addVenta(Venta venta){
        return this.ventaRepository.save(venta);
    }

    public Venta findById(Long id){
        return this.ventaRepository.findById(id).orElseThrow(() -> new apiRequestException("Esta vente no existe"));
    }

    public void desactivateVenta(Integer id){
        this.ventaRepository.desactivateVenta(id);
    }

    public void makeVenta(Integer cantidad, Integer id_ropa){
        this.ventaRepository.makeVenta(cantidad, id_ropa);
    }
}