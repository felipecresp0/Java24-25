import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();


        // 1º hacemos los dos tableros
        int[][] tableronumeros = new int[4][4];
        char[][] tablerousuario = new char[4][4];
        // 2º rellenamos los tableros
        //primero creamos las parejas de numeros
        ArrayList<Integer> numeros = new ArrayList<>();
        // 1. Generar pares de números del 1 al 8
        for (int i = 1; i <= 8; i++) {
            numeros.add(i);
            numeros.add(i); // Añade el mismo número dos veces para crear el par
        }

        // 2. Barajar los números
        Collections.shuffle(numeros, new Random());

        // Ahora rrelleno los tableros
        System.out.println("Tienes 10 segundos para recordar las parejas, ¡buena suerte!: ");
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tableronumeros[i][j] = numeros.get(index);
                index++;
                ;
                tablerousuario[i][j] = 'X';
            }
        }
        // Mostrar el tablero de números inicialmente
        System.out.println("Tablero de números:");
        mostrarTablero(tableronumeros);

        // Esperar 5 segundos
        long start = System.currentTimeMillis();
        Thread.sleep(10000); // pausa el programa por 10 segundos
        System.out.println("\nEl tiempo se ha acabado " + (System.currentTimeMillis() - start) + " milisegundos");

        // Mostrar el tablero de X después de los 10 segundos
        System.out.println("\nTablero oculto:");
        mostrarTablero(tablerousuario);
    }

    // Método para mostrar el tablero de números
    public static void mostrarTablero(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Sobrecarga del método para mostrar el tablero de caracteres
    public static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void encontrarlosnumeros(){
        Scanner scanner = new Scanner(System.in);
        int parejasEncontradas = 0;

        System.out.println("Dime el numero que crees recordar: ");

        while (parejasEncontradas < TOTAL_PAREJAS) {
            mostrarMatriz();
            System.out.print("Elige la primera posición (fila columna): ");
            int fila1 = scanner.nextInt();
            int col1 = scanner.nextInt();
            System.out.print("Elige la segunda posición (fila columna): ");
            int fila2 = scanner.nextInt();
            int col2 = scanner.nextInt();

            if (esValida(fila1, col1) && esValida(fila2, col2) && !(fila1 == fila2 && col1 == col2)) {
                descubrir(fila1, col1);
                descubrir(fila2, col2);
                mostrarMatriz();

                try {
                    Thread.sleep(2000); // Espera 2 segundos para mostrar los números
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                if (matriz[fila1][col1].equals(matriz[fila2][col2])) {
                    System.out.println("¡Encontraste una pareja!");
                    parejasEncontradas++;
                } else {
                    System.out.println("No son iguales. Intenta de nuevo.");
                    ocultar(fila1, col1);
                    ocultar(fila2, col2);
                }
            } else {
                System.out.println("Posición no válida. Intenta de nuevo.");
            }
        }
        System.out.println("¡Felicidades, encontraste todas las parejas!");
    }

    private static boolean esValida(int fila, int col) {
        return fila >= 0 && fila < FILAS && col >= 0 && col < COLUMNAS && !descubiertas[fila][col];
    }

    private static void descubrir(int fila, int col) {
        descubiertas[fila][col] = true;
    }

    private static void ocultar(int fila, int col) {
        descubiertas[fila][col] = false;
    }

    private static void mostrarMatriz() {
        System.out.println("Matriz de juego:");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (descubiertas[i][j]) {
                    System.out.print(matriz[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}