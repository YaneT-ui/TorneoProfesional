package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorteo {

    public List<Partido> sortear(List<Equipo> equipos)
            throws NumeroEquiposInvalidoException, SorteoInvalidoException {

        if (equipos == null || equipos.size() < 2
                || (equipos.size() & (equipos.size() - 1)) != 0) {
            throw new NumeroEquiposInvalidoException(
                    "La cantidad de equipos debe ser una potencia de 2.");
        }

        List<Equipo> mezclados = new ArrayList<>(equipos);
        Collections.shuffle(mezclados);

        List<Partido> partidos = new ArrayList<>();

        emparejarRecursivamente(mezclados, 0, partidos);

        return partidos;
    }

    private void emparejarRecursivamente(
            List<Equipo> equipos, int posicion, List<Partido> partidos)
            throws SorteoInvalidoException {

        if (posicion == equipos.size()) {
            return;
        }

        if (posicion + 1 >= equipos.size()) {
            throw new SorteoInvalidoException(
                    "No se pudo completar el emparejamiento.");
        }

        Partido partido = new Partido(
                equipos.get(posicion),
                equipos.get(posicion + 1)
        );

        partidos.add(partido);

        emparejarRecursivamente(equipos, posicion + 2, partidos);
    }
}