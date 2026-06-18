package com.yogaenequilibrio.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogaenequilibrio.ecommerce.model.Contacto;
import com.yogaenequilibrio.ecommerce.repository.ContactoRepository;
import com.yogaenequilibrio.ecommerce.service.ContactoService;

@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    public void guardar(Contacto contacto) {
        contactoRepository.save(contacto);
    }
}
