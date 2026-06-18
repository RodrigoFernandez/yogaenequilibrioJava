package com.yogaenequilibrio.ecommerce.service;

import java.util.List;

import com.yogaenequilibrio.ecommerce.model.Producto;

public interface ProductoService {

    public List<Producto> listar();
    public Producto obtenerPorId(Integer id);
    public Producto crear(Producto producto);
    public Producto actualizar(Integer id, Producto producto);
    public void eliminar(Integer id);
}
