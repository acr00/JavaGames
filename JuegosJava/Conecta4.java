package JuegosJava;
import java.util.Scanner;

public class Conecta4 {
   
    private static final int F = 6; 
    private static final int C = 7;
    private static char[][] tablero = new char[F][C]; 
    private static char jugadorActual = 'X'; 

    public static void main(String[] args) {

        inicializarTablero(); 
        boolean juegoTerminado = false; 
        Scanner scanner = new Scanner(System.in);

        
        while (!juegoTerminado) {

            mostrarTablero(); 
            System.out.println("Turno del jugador " + jugadorActual);
            System.out.println("Elige una columna (1-7): ");
            int columna = scanner.nextInt() - 1; 

            
            if (columna >= 0 && columna < C) {

                if (colocarFicha(columna)) { 
                    if (hayGanador()) { 
                    mostrarTablero();
                        System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
                        juegoTerminado = true; 
                    } else if (tableroLleno()) { 
                        mostrarTablero();
                        System.out.println("¡Empate! El tablero está lleno.");
                        juegoTerminado = true; 
                    } else {
                        cambiarTurno(); 
                    }
                } else {
                    System.out.println("Columna llena. Elige otra columna.");
                }
            } else {
                System.out.println("Columna no válida. Intentalo otra vez.");
            }
        }

        System.out.println("¿Quieres jugar otra vez? (s/n): ");
        char respuesta = scanner.next().charAt(0); 
        if (respuesta == 's') {

            reiniciarJuego(); 

        }
        scanner.close();
    }

    // Inicializa el tablero llenando todas las posiciones con el caracter '-'
    
    private static void inicializarTablero() {
        for (int i = 0; i < F; i++) {
            for (int j = 0; j < C; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    // Muestra el tablero de juego en la consola

    private static void mostrarTablero() {
        for (int i = 0; i < F; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println(); 
        }
        System.out.println("1 2 3 4 5 6 7"); 
    }

    // Coloca la ficha del jugador actual en la columna elegida, si es posible

    private static boolean colocarFicha(int columna) {
        for (int i = F - 1; i >= 0; i--) {
            if (tablero[i][columna] == '-') { 
                tablero[i][columna] = jugadorActual; 
                return true; 
            }
        }
        return false;
    }

    // Cambia el turno al otro jugador
    
    private static void cambiarTurno() {
        if (jugadorActual == 'X') {
            jugadorActual = 'O';
        } else {
            jugadorActual = 'X';
        }
    }


    private static boolean hayGanador() {

        // Verificación horizontal
        for (int i = 0; i < F; i++) {
            for (int j = 0; j < C - 3; j++) {
                if (tablero[i][j] == jugadorActual && tablero[i][j + 1] == jugadorActual
                        && tablero[i][j + 2] == jugadorActual && tablero[i][j + 3] == jugadorActual) {
                    return true; 
                }
            }
        }

        // Verificación vertical

        for (int i = 0; i < F - 3; i++) {
            for (int j = 0; j < C; j++) {
                if (tablero[i][j] == jugadorActual && tablero[i + 1][j] == jugadorActual
                        && tablero[i + 2][j] == jugadorActual && tablero[i + 3][j] == jugadorActual) {
                    return true; 
                }
            }
        }

        // (de izquierda a derecha)

        for (int i = 0; i < F - 3; i++) {
            for (int j = 0; j < C - 3; j++) {
                if (tablero[i][j] == jugadorActual && tablero[i + 1][j + 1] == jugadorActual
                        && tablero[i + 2][j + 2] == jugadorActual && tablero[i + 3][j + 3] == jugadorActual) {
                    return true; 
                }
            }
        }

        // (de derecha a izquierda)

        for (int i = 0; i < F - 3; i++) {
            for (int j = 3; j < C; j++) {
                if (tablero[i][j] == jugadorActual && tablero[i + 1][j - 1] == jugadorActual
                        && tablero[i + 2][j - 2] == jugadorActual && tablero[i + 3][j - 3] == jugadorActual) {
                    return true; 
                }
            }
        }

        return false; // Si no se encuentran 4 en línea, no gana ninguno de los dos jugadores
    }

    // Verifica si el tablero está lleno

    private static boolean tableroLleno() {
        for (int i = 0; i < C; i++) {
            if (tablero[0][i] == '-') {
                return false; 
            }
        }
        return true;
    }

    // Reinicia el tablero
    
    private static void reiniciarJuego() {
        inicializarTablero(); 
        jugadorActual = 'X'; 
        main(null); 
    }
}
