import com.company.entities.Paciente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import jakarta.persistence.*;

public class MenuPrincipalUI extends JFrame {
    private JTextField txtNombre, txtApellido, txtCedula;
    private JButton btnGuardar;

    // EntityManager para persistencia
    private EntityManagerFactory emf;
    private EntityManager em;

    public MenuPrincipalUI() {
        super("Registro de Paciente");

        // Configuración de JPA
        emf = Persistence.createEntityManagerFactory("com.mycompany_TareaUnidad002_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();

        // Campos de texto
        txtNombre = new JTextField(20);
        txtApellido = new JTextField(20);
        txtCedula = new JTextField(10);

        btnGuardar = new JButton("Guardar");

        // Layout
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Apellido:"));
        add(txtApellido);
        add(new JLabel("Cédula:"));
        add(txtCedula);
        add(new JLabel(""));
        add(btnGuardar);

        // Acción del botón
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarPaciente();
            }
        });

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void guardarPaciente() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtCedula.getText();

        // Crear entidad Paciente
        Paciente paciente = new Paciente();
        paciente.setNombres(nombre);
        paciente.setApellidos(apellido);

        // Persistir en BD
        em.getTransaction().begin();
        em.persist(paciente);
        em.getTransaction().commit();

        JOptionPane.showMessageDialog(this, "Paciente guardado exitosamente!");
    }

    // Método main: punto de entrada del programa
    public static void main(String[] args) {
        new MenuPrincipalUI(); // aquí arranca tu interfaz
    }

}
