import java.util.ArrayList;

public class AlmacenMusica implements IEstanteria {
    private ArrayList<Cancion> lstCanciones;

    public AlmacenMusica() {
        this.lstCanciones = new ArrayList<>();
    }

    @Override
    public void agregarCancion(Cancion c) {
        if (c != null) {
            lstCanciones.add(c);
            System.out.println("Canción agregada: " + c.getNombre());
        } else {
            System.out.println("Error: La canción no puede ser null.");
        }
    }

    @Override
    public void actualizarCancion(Cancion c) {
        for (int i = 0; i < lstCanciones.size(); i++) {
            if (lstCanciones.get(i).getNombre().equals(c.getNombre())) {
                lstCanciones.set(i, c);
                System.out.println("Canción actualizada: " + c.getNombre());
                return;
            }
        }
        System.out.println("Canción no encontrada.");
    }

    @Override
    public void eliminarCancion(Cancion c) {
        if (lstCanciones.remove(c)) {
            System.out.println("Canción eliminada: " + c.getNombre());
        } else {
            System.out.println("No se encontró la canción en la lista.");
        }
    }

    @Override
    public void mostrarCancion(Cancion c) {
        if (lstCanciones.contains(c)) {
            System.out.println(c);
        } else {
            System.out.println("La canción no está en la lista.");
        }
    }

    // Método extra para mostrar todas las canciones
    public void mostrarTodasLasCanciones() {
        if (lstCanciones.isEmpty()) {
            System.out.println("No hay canciones almacenadas.");
        } else {
            for (Cancion c : lstCanciones) {
                System.out.println(c);
            }
        }
    }
}
