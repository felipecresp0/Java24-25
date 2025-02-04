public class Main {
    public static void main(String[] args) {
        AlmacenMusica almacenMusica = new AlmacenMusica();

        Cancion c1 = new Cancion("Bohemian Rhapsody", "Queen", 354);
        Cancion c2 = new Cancion("Imagine", "John Lennon", 183);
        Cancion c3 = new Cancion("Hotel California", "Eagles", 390);

        almacenMusica.agregarCancion(c1);
        almacenMusica.agregarCancion(c2);
        almacenMusica.agregarCancion(c3);

        System.out.println("\nLista de canciones:");
        almacenMusica.mostrarTodasLasCanciones();

        // Actualizar una canción
        Cancion c1Nueva = new Cancion("Bohemian Rhapsody", "Queen", 360);
        almacenMusica.actualizarCancion(c1Nueva);

        // Eliminar una canción
        almacenMusica.eliminarCancion(c2);

        System.out.println("\nLista después de modificaciones:");
        almacenMusica.mostrarTodasLasCanciones();
    }
}
