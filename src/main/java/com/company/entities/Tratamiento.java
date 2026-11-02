package com.company.entities;

import jakarta.persistence.*;

// @Getter
// @Setter
// @NoArgsConstructor
@Entity
@Table(name = "tb_tratamiento")
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "trat_id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String descripcion;

    @Column(name = "costo", nullable = false)
    private Double costo;

    @Column(name = "estado", nullable = false)
    private String estado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "historia_id", nullable = false)
    private historiaClinica hisClinica;

    // Constructor vacío
    public Tratamiento() {}

    // Constructor con parámetros
    public Tratamiento(String descripcion, Double costo, String estado) {
        this.descripcion = descripcion;
        this.costo = costo;
        this.estado = estado;
    }

    // Getters y Setters manuales
    public Integer getId() { return id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getCosto() { return costo; }
    public void setCosto(Double costo) { this.costo = costo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public historiaClinica getHisClinica() { return hisClinica; }
    public void setHisClinica(historiaClinica hisClinica) { this.hisClinica = hisClinica; }
}
