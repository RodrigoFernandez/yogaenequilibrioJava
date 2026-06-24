package com.yogaenequilibrio.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

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
    public Optional<Producto> obtenerPorId(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto crear(Producto producto) {
        return productoRepository.save(producto);
    }

    private Producto actualizarProductoExistente(Producto existente, Producto nuevo) {
        // Actualiza los campos del producto existente con los valores del nuevo producto
        if(nuevo.getNombre() != null) {
            existente.setNombre(nuevo.getNombre());
        }

        if(nuevo.getDescripcion() != null) {
            existente.setDescripcion(nuevo.getDescripcion());
        }
        
        if(nuevo.getPrecio() != null) {
            existente.setPrecio(nuevo.getPrecio());
        }
        
        if(nuevo.getImagen() != null) {
            existente.setImagen(nuevo.getImagen());
        }
        
        if(nuevo.getEsNovedad() != null) {
            existente.setEsNovedad(nuevo.getEsNovedad());
        }

        if(nuevo.getEsDestacado() != null) {
            existente.setEsDestacado(nuevo.getEsDestacado());
        }

        return existente;
    }

    @Override
    public Optional<Producto> actualizar(Integer id, Producto producto) {
        if (productoRepository.existsById(id)) {
            Producto actualizado = this.actualizarProductoExistente(productoRepository.findById(id).get(), producto);
            return Optional.of(productoRepository.save(actualizado));
        }
        
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> eliminar(Integer id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return Optional.of(true);
        }
        
        return Optional.empty();
    }
}
