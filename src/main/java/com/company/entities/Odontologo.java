package com.company.entities;

import jakarta.persistence.*;

// @Getter
// @Setter
// @NoArgsConstructor
@Entity
@Table(name = "tb_odontologo")
public class Odontologo extends Persona {

    @Column(name = "especialidad", nullable = false)
    private String especialidad;

    // Constructor vacío
    public Odontologo() {
        super();
    }

    // Constructor con especialidad
    public Odontologo(String especialidad) {
        super();
        this.especialidad = especialidad;
    }

    // Getter y Setter manual
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}
