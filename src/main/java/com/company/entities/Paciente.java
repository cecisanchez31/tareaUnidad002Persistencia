package com.company.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "tb_paciente")
public class Paciente extends Persona {

    @Column(name = "estado", nullable = false)
    private String estado;

    // Constructor vacío
    public Paciente() {
        super();
    }

    // Constructor con estado
    public Paciente(String estado) {
        super();
        this.estado = estado;
    }

    // Getter y Setter manual
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    

    

    
}
