package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel {

    private JLabel labMapa;
    private List<Restaurante> restaurantes;

    public PanelMapaVisualizar() {
        this.labMapa = new JLabel(new ImageIcon("./imagenes/mapa.png"));
        labMapa.setBorder(new LineBorder(Color.DARK_GRAY));
        setLayout(new BorderLayout());
        add(labMapa, BorderLayout.CENTER);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        if (restaurantes != null) {
            g2d.setColor(Color.RED);
            g2d.setFont(new Font("Arial", Font.PLAIN, 12));

            // Draw a circle and label for each restaurant
            for (Restaurante restaurante : restaurantes) {
                // Get the restaurant coordinates
                int x = restaurante.getX();  // Get X coordinate
                int y = restaurante.getY();  // Get Y coordinate
                String nombre = restaurante.getNombre();  // Get restaurant name

                // Draw a small circle at the restaurant's coordinates
                g2d.fillOval(x - 3, y - 3, 7, 7);

                // Draw the restaurant name next to the circle
                g2d.drawString(nombre, x + 5, y - 5);
            }
        }
    }


    public void actualizarMapa(List<Restaurante> nuevosRestaurantes) {
        if (restaurantes != null) {
            this.restaurantes.clear();
            this.restaurantes.addAll(nuevosRestaurantes);
        } else {
            this.restaurantes = nuevosRestaurantes;
        }
        repaint();
    }
}
