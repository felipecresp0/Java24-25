import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);

        // 1. Crear los tableros
        int[][] tableronumeros = new int[4][4];
        char[][] tablerousuario = new char[4][4];

        // 2. Generar parejas de números aleatorios y mezclar
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            numeros.add(i);
            numeros.add(i);
        }
        Collections.shuffle(numeros);

        // 3. Rellenar el tablero de números y el tablero oculto
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tableronumeros[i][j] = numeros.get(index++);
                tablerousuario[i][j] = 'X';
            }
        }

        // Mostrar el tablero de números durante 10 segundos
        System.out.println("Tienes 10 segundos para memorizar el tablero:");
        mostrarTablero(tableronumeros);
        Thread.sleep(10000);

        // Limpiar la pantalla para ocultar el tablero de números
        System.out.println("\nEl tiempo se ha acabado. Ahora el tablero está oculto.");
        mostrarTablero(tablerousuario);

        // Juego: el usuario intenta adivinar parejas
        int parejasEncontradas = 0;
        while (parejasEncontradas < 8) {
            System.out.print("Ingresa el número que recuerdas: ");
            int numero = teclado.nextInt();

            // Pedir la primera posición para buscar el número
            System.out.print("Ingresa las coordenadas de la primera posición (fila columna): ");
            int fila1 = teclado.nextInt();
            int col1 = teclado.nextInt();

            // Verificar si el número está en la primera posición
            if (tableronumeros[fila1][col1] == numero) {
                // Pedir la segunda posición para buscar la pareja
                System.out.print("Ingresa las coordenadas de la segunda posición (fila columna): ");
                int fila2 = teclado.nextInt();
                int col2 = teclado.nextInt();

                // Comprobar si las coordenadas son válidas y contienen el mismo número
                if (tableronumeros[fila2][col2] == numero && (fila1 != fila2 || col1 != col2)) {
                    System.out.println("¡Enhorabuena, has encontrado una pareja!");
                    parejasEncontradas++;
                    tablerousuario[fila1][col1] = (char) (numero + '0');
                    tablerousuario[fila2][col2] = (char) (numero + '0');
                } else {
                    System.out.println("Lo siento :(, intentalo de nuevo.");
                }
            } else {
                System.out.println("El número no coincide con la primera posición. Inténtalo de nuevo.");
            }

            // Mostrar el tablero visible del usuario
            mostrarTablero(tablerousuario);
        }

        System.out.println("¡Felicidades, has encontrado todas las parejas!");
        teclado.close();
    }

    // Métodos para mostrar los tableros
    public static void mostrarTablero(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
