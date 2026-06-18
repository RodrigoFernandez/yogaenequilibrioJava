package com.yogaenequilibrio.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogaenequilibrio.ecommerce.model.Producto;
import com.yogaenequilibrio.ecommerce.repository.ProductoRepository;
import com.yogaenequilibrio.ecommerce.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerPorId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto crear(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizar(Integer id, Producto producto) {
        if (productoRepository.existsById(id)) {
            producto.setId(id);
            return productoRepository.save(producto);
        }
        
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }
}
