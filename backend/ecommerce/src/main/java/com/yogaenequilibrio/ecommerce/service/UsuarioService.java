package com.yogaenequilibrio.ecommerce.service;

import com.yogaenequilibrio.ecommerce.model.Usuario;

public interface UsuarioService {

    public Usuario obtenerPorNombreYContrasenia(String nombre, String contrasenia);
}
