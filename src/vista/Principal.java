package vista;

import controlador.ControladorTorneo;
import modelo.Equipo;
import modelo.Torneo;
import modelo.NumeroEquiposInvalidoException;
import modelo.SorteoInvalidoException;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) {

        Torneo torneo = new Torneo();

        String[] nombres = {
            "Barcelona SC",
            "Emelec",
            "Liga de Quito",
            "Independiente del Valle",
            "Aucas",
            "El Nacional",
            "Deportivo Cuenca",
            "Delfin SC",
            "Orense SC",
            "Macara",
            "Mushuc Runa",
            "Universidad Catolica",
            "Tecnico Universitario",
            "Libertad FC",
            "Cumbaya FC",
            "Manta FC"
        };

        for (String nombre : nombres) {
            torneo.agregarEquipo(new Equipo(nombre));
        }

        VistaTorneo vista = new VistaTorneo();

        vista.mostrarEquipos(torneo.getEquipos());

        try {

            torneo.guardar("torneo.ser");
            vista.mostrarMensaje("Torneo guardado correctamente.");

            torneo = Torneo.cargar("torneo.ser");
            vista.mostrarMensaje("Torneo recuperado correctamente.");

            ControladorTorneo controlador =
                    new ControladorTorneo(torneo);

            controlador.iniciarTorneo(vista);

        } catch (NumeroEquiposInvalidoException |
                 SorteoInvalidoException e) {

            vista.mostrarMensaje("Error en el sorteo: " + e.getMessage());

        } catch (IOException e) {

            vista.mostrarMensaje("Error al guardar o cargar: " + e.getMessage());

        } catch (ClassNotFoundException e) {

            vista.mostrarMensaje("No se encontró la clase del torneo.");

        }
    }
}