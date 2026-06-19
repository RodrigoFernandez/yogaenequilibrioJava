package com.yogaenequilibrio.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.yogaenequilibrio.ecommerce.model.Producto;

public interface ProductoService {

    public List<Producto> listar();
    public Optional<Producto> obtenerPorId(Integer id);
    public Producto crear(Producto producto);
    public Optional<Producto> actualizar(Integer id, Producto producto);
    public Optional<Boolean> eliminar(Integer id);
}
