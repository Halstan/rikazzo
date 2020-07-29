package com.rikazzo.rikazzo.service;

import com.rikazzo.rikazzo.entity.Usuario;
import com.rikazzo.rikazzo.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class usuarioService {

    private final usuarioRepository usuarioRepository;

    @Autowired
    public usuarioService(usuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll(){
        return this.usuarioRepository.findAll();
    }

    public Usuario addUser(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

    public Usuario updateUser(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

    public Usuario findById(Integer id){
        return this.usuarioRepository.findById(id).get();
    }

    public void deleteUser(Integer id){
        this.usuarioRepository.deleteById(id);
    }
}
