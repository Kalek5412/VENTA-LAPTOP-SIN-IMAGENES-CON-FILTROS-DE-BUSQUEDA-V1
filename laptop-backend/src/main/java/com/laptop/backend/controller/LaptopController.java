package com.laptop.backend.controller;

import com.laptop.backend.criterio.LaptopCriterio;
import com.laptop.backend.dto.BusquedaDTO;
import com.laptop.backend.enums.Color;
import com.laptop.backend.model.Laptop;
import com.laptop.backend.service.LaptopServiceImpl;
import io.github.jhipster.service.filter.BigDecimalFilter;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;
import net.logstash.logback.encoder.org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
@CrossOrigin(origins = "http://localhost:4200")
public class LaptopController {

    @Autowired
    private LaptopServiceImpl laptopService;

    @PostMapping("/list")
    public ResponseEntity<List<Laptop>> listadoDeLaptop(@RequestBody BusquedaDTO busquedaDTO){
        LaptopCriterio laptopCriterio = crearCriterio(busquedaDTO);
        List<Laptop> listado= laptopService.findByCriteria(laptopCriterio);
        return new ResponseEntity<List<Laptop>>(listado, HttpStatus.OK);
    }


    private LaptopCriterio crearCriterio(BusquedaDTO dto){
        LaptopCriterio laptopCriterio=new LaptopCriterio();
        if(dto!=null){
            if(!StringUtils.isBlank(dto.getMarca())){
                StringFilter filter=new StringFilter();
                filter.setEquals(dto.getMarca());
                laptopCriterio.setMarca(filter);
            }
            if(!StringUtils.isBlank(dto.getModelo())){
                StringFilter filter=new StringFilter();
                filter.setEquals(dto.getModelo());
                laptopCriterio.setModelo(filter);
            }
            if(!StringUtils.isBlank(dto.getVersion())){
                StringFilter filter=new StringFilter();
                filter.setContains(dto.getVersion());
                laptopCriterio.setVersion(filter);
            }
            if(!StringUtils.isBlank(dto.getNuevo())){
                BooleanFilter filter = new BooleanFilter();
                switch (dto.getNuevo()){
                    case "true":
                        filter.setEquals(true);
                        break;
                    case "false":
                        filter.setEquals(false);
                        break;
                    default:
                        filter.setEquals(false);
                        break;
                }
                laptopCriterio.setNuevo(filter);
            }
            if(!StringUtils.isBlank(dto.getColor())){
                LaptopCriterio.ColorFilter filter=new LaptopCriterio.ColorFilter();
                String color= dto.getColor().toUpperCase();
                filter.setEquals(Color.valueOf(color));
                laptopCriterio.setColor(filter);
            }
            if(dto.getPrecioDesde()!=null  || dto.getPrecioHasta()!=null){
                BigDecimalFilter filter=new BigDecimalFilter();
                if(dto.getPrecioDesde()!= null){
                    filter.setGreaterThanOrEqual(dto.getPrecioDesde());
                    laptopCriterio.setPrecio(filter);
                }
                if(dto.getPrecioHasta()!= null){
                    filter.setLessThanOrEqual(dto.getPrecioHasta());
                    laptopCriterio.setPrecio(filter);
                }
            }



        }
        return laptopCriterio;
    }
}
