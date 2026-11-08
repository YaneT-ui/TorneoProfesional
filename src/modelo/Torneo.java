package modelo;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Torneo implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Equipo> equipos;

    public Torneo() {
        equipos = new ArrayList<>();
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void guardar(String archivo) throws IOException {
        ObjectOutputStream salida = new ObjectOutputStream(
                new FileOutputStream(archivo));

        salida.writeObject(this);
        salida.close();
    }

    public static Torneo cargar(String archivo)
            throws IOException, ClassNotFoundException {

        ObjectInputStream entrada = new ObjectInputStream(
                new FileInputStream(archivo));

        Torneo torneo = (Torneo) entrada.readObject();
        entrada.close();

        return torneo;
    }
}