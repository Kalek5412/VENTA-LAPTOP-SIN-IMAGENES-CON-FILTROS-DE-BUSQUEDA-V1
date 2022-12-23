package com.laptop.backend.controller;


import com.laptop.backend.criterio.LaptopCriterio;
import com.laptop.backend.dto.BusquedaDTO;
import com.laptop.backend.model.Marca;
import com.laptop.backend.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marcas")
@CrossOrigin(origins = "http://localhost:4200")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Marca>> listadoDeMarcas(){
        List<Marca> listado = marcaService.listarMarca();
        return  new ResponseEntity<List<Marca>>(listado,HttpStatus.OK);
    }

}
