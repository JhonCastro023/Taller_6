package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel {

    private JTextField txtNombre;
    private JComboBox<String> cbbCalificacion;
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante() {
        setLayout(new GridLayout(3, 2, 10, 10));

        // Crear el campo para el nombre con una etiqueta
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();
        add(lblNombre);
        add(txtNombre);

        // Crear el selector para la calificación con una etiqueta
        JLabel lblCalificacion = new JLabel("Calificación:");
        String[] calificaciones = { "1", "2", "3", "4", "5" };
        cbbCalificacion = new JComboBox<>(calificaciones);
        add(lblCalificacion);
        add(cbbCalificacion);

        // Crear el selector para indicar si fue visitado con una etiqueta
        JLabel lblVisitado = new JLabel("¿Visitado?");
        String[] opcionesVisitado = { "Sí", "No" };
        cbbVisitado = new JComboBox<>(opcionesVisitado);
        add(lblVisitado);
        add(cbbVisitado);
    }

    public boolean getVisitado() {
        return cbbVisitado.getSelectedItem().equals("Sí");
    }

    public int getCalificacion() {
        String calif = (String) cbbCalificacion.getSelectedItem();
        return Integer.parseInt(calif);
    }

    public String getNombre() {
        return txtNombre.getText().trim();
    }
}
