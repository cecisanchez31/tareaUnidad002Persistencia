package com.mycompany.tareaunidad002.Menu;

import com.company.entities.Paciente;
import com.company.entities.historiaClinica;
import com.company.entities.Tratamiento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;

public class TareaUnidad002 {

    public static void main(String[] args) {
        // Crear el EntityManagerFactory con el nombre de tu persistence-unit
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_TareaUnidad002_jar_1.0-SNAPSHOTPU");
        EntityManager manager = emf.createEntityManager();

        try {
            manager.getTransaction().begin();

            // Crear un paciente válido
            Paciente paciente = new Paciente();
            paciente.setEstado("Activo");
            paciente.setNombres("Juan Carlos");
            paciente.setApellidos("Ramirez Mendieta");
            paciente.setFechaNacimiento(new Date());
            paciente.setDireccion("Loja");

            manager.persist(paciente);

            // Crear historia clínica asociada al paciente
            historiaClinica hc1 = new historiaClinica();
            hc1.setFecha(new Date());
            hc1.setMotivoConsulta("Dolor de muela");
            hc1.setDiagnostico("Pendiente");
            hc1.setPaciente(paciente);

            manager.persist(hc1);

            // Crear tratamiento asociado a la historia clínica
            Tratamiento tratamiento = new Tratamiento();
            tratamiento.setDescripcion("Extracción de muela");
            tratamiento.setCosto(50.0);
            tratamiento.setEstado("Pendiente");
            tratamiento.setHisClinica(hc1);

            manager.persist(tratamiento);

            manager.getTransaction().commit();
            System.out.println("Paciente, historia clínica y tratamiento guardados exitosamente!");
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            manager.close();
            emf.close();
        }
    }
}
