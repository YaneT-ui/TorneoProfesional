package modelo;

import java.io.Serializable;

public class Partido implements Serializable {

    private static final long serialVersionUID = 1L;

    private Equipo equipo1;
    private Equipo equipo2;

    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    @Override
    public String toString() {
        return equipo1 + " vs " + equipo2;
    }
}