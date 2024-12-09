package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame {

    private PanelEditarRestaurante panelDetalles;
    private PanelBotonesAgregar panelBotones;
    private PanelMapaAgregar panelMapa;
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante(VentanaPrincipal principal) {
        this.ventanaPrincipal = principal;
        setTitle("Agregar Restaurante");
        setLayout(new BorderLayout());

        // Panel para el mapa
        panelMapa = new PanelMapaAgregar();
        add(panelMapa, BorderLayout.CENTER);

        // Panel para los detalles y botones
        JPanel panelSur = new JPanel(new BorderLayout());
        panelDetalles = new PanelEditarRestaurante();
        panelBotones = new PanelBotonesAgregar(this);

        panelSur.add(panelDetalles, BorderLayout.CENTER);
        panelSur.add(panelBotones, BorderLayout.SOUTH);

        add(panelSur, BorderLayout.SOUTH);

        // Configuración final de la ventana
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public void agregarRestaurante() {
        String nombre = panelDetalles.getNombre();
        int calificacion = panelDetalles.getCalificacion();
        boolean visitado = panelDetalles.getVisitado();
        int[] coordenadas = panelMapa.getCoordenadas();

        ventanaPrincipal.crearRestaurante(nombre, calificacion, visitado, coordenadas);
        cerrarVentana();
    }

    public void cerrarVentana() {
        dispose();
    }
}

