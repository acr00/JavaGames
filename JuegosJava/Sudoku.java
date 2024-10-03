package JuegosJava;
import java.util.Scanner;

public class Sudoku {
    private static final int SIZE = 9;
    private static final int EMPTY = 0;
    private int[][] tablero = new int[SIZE][SIZE];

    public Sudoku() {

        inicializarTablero();
    }

    private void inicializarTablero() {
        
        tablero[0][0] = 5;
        tablero[1][1] = 3;
        tablero[2][2] = 4;
        
    }

    public void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean MovimientoValido(int row, int col, int num) {

        // Verificar fila
        for (int i = 0; i < SIZE; i++) {
            if (tablero[row][i] == num) {
                return false;
            }
        }
        // Verificar columna
        for (int i = 0; i < SIZE; i++) {
            if (tablero[i][col] == num) {
                return false;
            }
        }
        // Verificar bloque 3x3
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isComplete() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (tablero[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            displayBoard();

            System.out.println("Ingrese 'resolver' para resolver el Sudoku,'reiniciar' para reiniciar la partida, o cualquier otra tecla para continuar jugando:");
            String input = scanner.next();

            if (input.equalsIgnoreCase("resolver")) {

                if (resolverSudoku()) {

                    System.out.println("Sudoku resuelto:");
                    displayBoard();

                } else {

                    System.out.println("No se pudo resolver el Sudoku.");
                }

                break;

            } else if (input.equalsIgnoreCase("reiniciar")) {

                reiniciarPartida();

            } else {

                int row = getInput(scanner, "Ingrese las coordenadas (fila) : ") - 1;

                int col = getInput(scanner, "Ingrese las coordenadas (columna) :") - 1;

                int num = getInput(scanner, "Ingrese el número a colocar :");

                if (MovimientoValido(row, col, num)) {

                    tablero[row][col] = num;
                } else {
                    System.out.println("Movimiento inválido. Intente de nuevo.");
                }
            }
            if (isComplete()) {
                System.out.println("¡Felicidades! Has completado el Sudoku.");
                break;
            }
        }
        scanner.close();
    }

    private boolean resolverSudoku() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (tablero[row][col] == EMPTY) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (MovimientoValido(row, col, num)) {
                            tablero[row][col] = num;
                            if (resolverSudoku()) {
                                return true;
                            } else {
                                tablero[row][col] = EMPTY;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private void reiniciarPartida() {
        System.out.println("Reiniciando la partida...");
        tablero = new int[SIZE][SIZE];
        inicializarTablero();
    }

    private int getInput(Scanner scanner, String prompt) {
        int input;
        do {
            System.out.println(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input < 1 || input > 9);
        return input;
    }

    public static void main(String[] args) {
        sudoku sudoku = new sudoku();
        sudoku.play();
    }
}
