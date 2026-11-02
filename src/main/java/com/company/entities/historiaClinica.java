package com.company.entities;

import jakarta.persistence.*;
import java.util.Date;

// @Getter
// @Setter
// @NoArgsConstructor
@Entity
@Table(name = "tb_historia_clinica")
public class historiaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String motivoConsulta;
    private String diagnostico;

    @OneToOne(optional = false)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    // Constructor vacío
    public historiaClinica() {}

    // Constructor con parámetros
    public historiaClinica(Date fecha, String motivoConsulta, String diagnostico) {
        this.fecha = fecha;
        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;
    }

    // Getters y Setters manuales
    public Integer getId() { return id; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getMotivoConsulta() { return motivoConsulta; }
    public void setMotivoConsulta(String motivoConsulta) { this.motivoConsulta = motivoConsulta; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
}
