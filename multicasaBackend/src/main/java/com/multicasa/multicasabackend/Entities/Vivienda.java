package com.multicasa.multicasabackend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "vivienda")
public class Vivienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "cp", nullable = false, length = 5)
    private String cp;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "recamaras", nullable = false)
    private Integer recamaras;

    @Column(name = "banos", nullable = false)
    private Integer banos;

    @Column(name = "vendida", nullable = false)
    private Boolean vendida = false;

    @Column(name = "ts_sold", nullable = false)
    private LocalDate tsSold;

    @Column(name = "lat", nullable = false, length = 20)
    private String lat;

    @Column(name = "lon", nullable = false, length = 20)
    private String lon;

    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

}