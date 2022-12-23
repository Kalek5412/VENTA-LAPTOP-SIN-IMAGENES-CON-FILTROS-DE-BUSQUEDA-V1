package com.laptop.backend.service;

import com.laptop.backend.criterio.LaptopCriterio;
import com.laptop.backend.model.Laptop;
import com.laptop.backend.model.Laptop_;
import com.laptop.backend.model.Marca_;
import com.laptop.backend.model.Modelo_;
import com.laptop.backend.repository.LaptopRepository;
import io.github.jhipster.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;
import java.util.List;

@Service
public class LaptopServiceImpl extends QueryService<Laptop>{

    @Autowired
    private LaptopRepository laptopRepository;

    public List<Laptop> findByCriteria(LaptopCriterio laptopCriterio) {
        final Specification<Laptop> specification= createSpecification(laptopCriterio);
        List<Laptop> laptops = laptopRepository.findAll(specification);
        return  laptops;
    }



    private Specification<Laptop> createSpecification(LaptopCriterio criterio){
        Specification<Laptop> specification = Specification.where(null);
        if(criterio !=null){
            if(criterio.getVersion()!=null){
                specification=specification.and(buildStringSpecification(criterio.getVersion(), Laptop_.version));
            }
            if(criterio.getColor()!=null){
                specification=specification.and(buildSpecification(criterio.getColor(),Laptop_.color));
            }
            if(criterio.getPrecio()!=null){
                specification=specification.and(buildRangeSpecification(criterio.getPrecio(),Laptop_.precio));
            }
            if(criterio.getNuevo()!=null){
                specification=specification.and(buildSpecification(criterio.getNuevo(),Laptop_.nuevo));
            }
            if(criterio.getModelo()!=null){
                specification=specification.and(buildReferringEntitySpecification(criterio.getModelo(),Laptop_.modelo, Modelo_.nombre));
            }
//            if(criterio.getModelo()!=null){
//                specification=specification.and(buildSpecification(criterio.getModelo(),
//                        root->root.join(Laptop_.modelo, JoinType.LEFT).get(Modelo_.nombre)));
//            }
            if(criterio.getMarca()!=null){
                specification=specification.and(buildSpecification(criterio.getMarca(),
                        root-> root.join(Laptop_.modelo,JoinType.LEFT).join(
                                Modelo_.marca,JoinType.LEFT).get(Marca_.nombre)
                        ));
            }
        }
        return specification;
    }
}
