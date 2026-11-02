/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "tb_cita_medica")
@Getter
@Setter
@NoArgsConstructor
public class citaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cita_id", nullable = false)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", nullable = false)
    private java.util.Date fecha;

    @Temporal(TemporalType.TIME)
    @Column(name = "hora", nullable = false)
    private java.util.Date hora;

    @Column(name = "estado", nullable = false)
    private String estado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "historia_id", nullable = false)
    private historiaClinica historiaClinica;

    public citaMedica(java.util.Date fecha, java.util.Date hora, String estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }
}
