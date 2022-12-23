package com.laptop.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "modelos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("modelos")
    private Marca marca;

    @OneToMany(mappedBy = "modelo")
    private List<Laptop> laptops = new ArrayList<>();
}
