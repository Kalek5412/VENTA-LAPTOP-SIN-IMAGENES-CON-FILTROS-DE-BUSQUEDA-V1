package com.laptop.backend.criterio;

import com.laptop.backend.enums.Color;
import io.github.jhipster.service.filter.*;
import lombok.Data;

@Data
public class LaptopCriterio {

    public static class ColorFilter extends Filter<Color>{}

    private StringFilter marca;
    private StringFilter modelo;
    private StringFilter version;
    private BooleanFilter nuevo;
    private ColorFilter color;
    private BigDecimalFilter precio;
}
