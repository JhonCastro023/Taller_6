package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class VentanaMapa extends JFrame implements ActionListener {

    private static final String VISITADOS = "VISITADOS";
    private static final String TODOS = "TODOS";

    private PanelMapaVisualizar panelMapa;
    private JRadioButton radioTodos;
    private JRadioButton radioVisitados;
    private VentanaPrincipal ventanaPrincipal;

    public VentanaMapa(VentanaPrincipal ventanaPrincipal, List<Restaurante> restaurantes) {
        this.ventanaPrincipal = ventanaPrincipal;
        
        setTitle("Mapa de Restaurantes");
        setLayout(new BorderLayout());

        // Crear el panel de mapa
        panelMapa = new PanelMapaVisualizar();
        panelMapa.actualizarMapa(restaurantes);  // Inicializa el mapa con todos los restaurantes
        add(panelMapa, BorderLayout.CENTER);

        // Crear los radio buttons
        JPanel panelRadioButtons = new JPanel();
        radioTodos = new JRadioButton("Todos");
        radioVisitados = new JRadioButton("Visitados");
        
        radioTodos.setActionCommand(TODOS);
        radioVisitados.setActionCommand(VISITADOS);
        
        radioTodos.addActionListener(this);
        radioVisitados.addActionListener(this);

        // Agrupar los botones para que solo uno pueda estar seleccionado
        ButtonGroup group = new ButtonGroup();
        group.add(radioTodos);
        group.add(radioVisitados);

        // Agregar los radio buttons al panel
        panelRadioButtons.add(radioTodos);
        panelRadioButtons.add(radioVisitados);
        
        add(panelRadioButtons, BorderLayout.SOUTH);

        // Configuración de la ventana
        setSize(800, 600);
        pack();
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (TODOS.equals(comando)) {
            panelMapa.actualizarMapa(ventanaPrincipal.getRestaurantes(true)); // Mostrar todos los restaurantes
        } else if (VISITADOS.equals(comando)) {
            panelMapa.actualizarMapa(ventanaPrincipal.getRestaurantes(false)); // Mostrar solo los visitados
        }
    }
}
