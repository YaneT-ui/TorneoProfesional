package vista;

import java.util.List;
import modelo.Equipo;
import modelo.Partido;

public class VistaTorneo {

    public void mostrarEquipos(List<Equipo> equipos) {
        System.out.println("\n===== EQUIPOS DEL TORNEO =====");

        for (Equipo equipo : equipos) {
            System.out.println(equipo);
        }
    }

    public void mostrarPartidos(List<Partido> partidos, String etapa) {
        System.out.println("\n===== " + etapa + " =====");

        int numero = 1;

        for (Partido partido : partidos) {
            System.out.println("Partido " + numero + ": " + partido);
            numero++;
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}