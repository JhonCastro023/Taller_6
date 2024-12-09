package uniandes.dpoo.swing.interfaz.principal;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;

import uniandes.dpoo.swing.interfaz.agregar.VentanaAgregarRestaurante;
import uniandes.dpoo.swing.interfaz.mapa.VentanaMapa;
import uniandes.dpoo.swing.mundo.Diario;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame
{
    private Diario mundo;
    private PanelBotones pBotones;
    private PanelDetallesRestaurante pDetalles;
    private PanelLista pLista;
    private VentanaMapa ventanaMapa;
    private VentanaAgregarRestaurante ventanaAgregar;

    public VentanaPrincipal(Diario elDiario)
    {
        this.mundo = elDiario;
        setLayout(new BorderLayout());
        pBotones = new PanelBotones(this);
        add(pBotones, BorderLayout.NORTH);

        pLista = new PanelLista(this);
        add(pLista);

        pDetalles = new PanelDetallesRestaurante();
        add(pDetalles, BorderLayout.SOUTH);
        actualizarRestaurantes();
        setTitle("Restaurantes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void mostrarVetanaNuevoRestaurante()
    {
        if (ventanaAgregar == null || !ventanaAgregar.isVisible())
        {
            ventanaAgregar = new VentanaAgregarRestaurante(this);
            ventanaAgregar.setVisible(true);
        }
    }

    public void mostrarVentanaMapa()
    {
        if (ventanaMapa == null || !ventanaMapa.isVisible())
        {
            ventanaMapa = new VentanaMapa(this, mundo.getRestaurantes(true));
            ventanaMapa.setVisible(true);
        }
    }
    public void crearRestaurante(String nombre, int calificacion, boolean visitado, int[] coordenadas) {
        Restaurante nuevoRestaurante = new Restaurante(nombre, calificacion, coordenadas[0], coordenadas[1], visitado);
        mundo.agregarRestaurante(nuevoRestaurante);
        actualizarRestaurantes();
    }


    public void agregarRestaurante(String nombre, int calificacion, int x, int y, boolean visitado)
    {
        Restaurante nuevoRestaurante = new Restaurante(nombre, calificacion, x, y, visitado);
        mundo.agregarRestaurante(nuevoRestaurante);
        actualizarRestaurantes();
    }

    public List<Restaurante> getRestaurantes(boolean completos)
    {
        return mundo.getRestaurantes(completos);
    }

    private void actualizarRestaurantes()
    {
        List<Restaurante> todos = this.mundo.getRestaurantes(true);
        pLista.actualizarRestaurantes(todos);

        if (todos.size() > 0)
        {
            cambiarRestauranteSeleccionado(todos.get(0));
        }
    }

    public void cambiarRestauranteSeleccionado(Restaurante seleccionado)
    {
        pDetalles.actualizarRestaurante(seleccionado);
    }

    public static void main(String[] args)
    {
        Diario elDiario = new Diario();
        elDiario.agregarRestaurante(new Restaurante("Pita Pan", 4, 30, 30, true));
        elDiario.agregarRestaurante(new Restaurante("Lord of the Wings", 5, 170, 210, true));
        elDiario.agregarRestaurante(new Restaurante("Nacho Business", 2, 350, 170, false));
        elDiario.agregarRestaurante(new Restaurante("Thai Tanic", 1, 110, 100, false));
        elDiario.agregarRestaurante(new Restaurante("Planet of the Creppes", 3, 400, 400, true));

        new VentanaPrincipal(elDiario);
    }
}

