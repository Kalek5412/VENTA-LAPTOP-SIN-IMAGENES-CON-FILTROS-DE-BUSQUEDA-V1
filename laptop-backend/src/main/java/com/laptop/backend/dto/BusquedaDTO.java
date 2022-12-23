package com.laptop.backend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BusquedaDTO {
    private String marca;
    private String modelo;
    private String version;
    private String nuevo;
    private String color;
    private BigDecimal precioDesde;
    private BigDecimal precioHasta;
}
