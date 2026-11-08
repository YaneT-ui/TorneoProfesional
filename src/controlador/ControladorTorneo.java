package controlador;

import modelo.Equipo;
import modelo.Torneo;
import modelo.Partido;
import modelo.Sorteo;
import modelo.NumeroEquiposInvalidoException;
import modelo.SorteoInvalidoException;
import vista.VistaTorneo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ControladorTorneo {

    private Torneo torneo;
    private Sorteo sorteo;
    private Random aleatorio = new Random();

    public ControladorTorneo(Torneo torneo) {
        this.torneo = torneo;
        this.sorteo = new Sorteo();
    }

    public void iniciarTorneo(VistaTorneo vista)
            throws NumeroEquiposInvalidoException,
            SorteoInvalidoException {

        List<Equipo> equipos = torneo.getEquipos();

        String[] etapas = {
            "OCTAVOS DE FINAL",
            "CUARTOS DE FINAL",
            "SEMIFINALES",
            "FINAL"
        };

        int etapa = 0;

        while (equipos.size() > 1 && etapa < etapas.length) {

            List<Partido> partidos = sorteo.sortear(equipos);

            vista.mostrarPartidos(partidos, etapas[etapa]);

            List<Equipo> ganadores = new ArrayList<>();

            for (Partido partido : partidos) {

                Equipo ganador;

                if (aleatorio.nextBoolean()) {
                    ganador = partido.getEquipo1();
                } else {
                    ganador = partido.getEquipo2();
                }

                ganadores.add(ganador);
                vista.mostrarMensaje("Clasifica: " + ganador);
            }

            equipos = ganadores;
            etapa++;
        }

        if (equipos.size() == 1) {
            vista.mostrarMensaje(
                "\nCAMPEON DEL TORNEO: " + equipos.get(0));
        }
    }
}