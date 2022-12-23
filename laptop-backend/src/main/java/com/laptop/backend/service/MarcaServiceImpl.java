package com.laptop.backend.service;

import com.laptop.backend.model.Marca;
import com.laptop.backend.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<Marca> listarMarca() {
        return marcaRepository.findAll();
    }
}
