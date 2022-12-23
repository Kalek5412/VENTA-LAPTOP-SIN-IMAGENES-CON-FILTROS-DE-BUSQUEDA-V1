package com.laptop.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.laptop.backend.enums.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Entity
@Table(name = "laptops")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String version;
    private boolean nuevo;
    @Enumerated(EnumType.STRING)
    private Color color;
    @Min(0)
    private BigDecimal precio;
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("laptops")
    private Modelo modelo;
}
