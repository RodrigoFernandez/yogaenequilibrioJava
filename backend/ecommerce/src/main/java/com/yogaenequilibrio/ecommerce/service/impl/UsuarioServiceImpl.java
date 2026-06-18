package com.yogaenequilibrio.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogaenequilibrio.ecommerce.model.Usuario;
import com.yogaenequilibrio.ecommerce.repository.UsuarioRepository;
import com.yogaenequilibrio.ecommerce.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario obtenerPorNombreYContrasenia(String nombre, String contrasenia) {
        return usuarioRepository.findById(nombre)
                .filter(usuario -> usuario.getContrasenia().equals(contrasenia))
                .orElse(null);
    }
}
