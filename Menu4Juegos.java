import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

// Importamos las librerias necesarias para el menu, en este caso voy a poner JOptionPane para poner 4 opciones y ImageIcon para poner
// una imagen en cada opcion y que sea mas interactivo

public class Menu4Juegos {
    public static void main(String[] args) {

        // Crear las opciones del menú

        String[] opciones =     { "Sudoku", "Conecta 4" , "Ahorcado" , "Adivina el número" };

        // Creamos los huecos para cada imagen que hemos elegido y ponemos la ruta de donde recogera esas imagenes

        ImageIcon Sicon1 =      new ImageIcon    ("C:\\Users\\adria\\Desktop\\ProyectosClase\\MenuJuegos\\IconSudoku.png");
        ImageIcon Cicon2 =      new ImageIcon    ("C:\\Users\\adria\\Desktop\\ProyectosClase\\MenuJuegos\\IconConecta4.png");
        ImageIcon Ahicon3 =     new ImageIcon    ("C:\\Users\\adria\\Desktop\\ProyectosClase\\MenuJuegos\\IconAhorcado.png");
        ImageIcon ANicon4 =     new ImageIcon    ("C:\\Users\\adria\\Desktop\\ProyectosClase\\MenuJuegos\\IconAdivinaNumero.png");

        // Mostrar el menú de opciones

        int seleccion = JOptionPane.showOptionDialog(null, "Selecciona un juego", "Menú de Juegos",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        // Realizar una acción según la opción seleccionada

        switch (seleccion) {
            case 0:

                // Opcion del juego de Sudoku con un cuadro de texto

                JOptionPane.showMessageDialog(null, " Has seleccionado Sudoku ",
                         "Sudoku", JOptionPane.INFORMATION_MESSAGE , Sicon1);
                break;
            case 1:
                // Lógica para el juego de Conecta 4
                JOptionPane.showMessageDialog(null, " Has seleccionado Conecta 4 ",
                         "Conecta 4", JOptionPane.INFORMATION_MESSAGE , Cicon2);
                break;
            case 2:
                // Lógica para el juego de Ahorcado
                JOptionPane.showMessageDialog(null, " Has seleccionado Ahorcado ",
                         "Ahorcado", JOptionPane.INFORMATION_MESSAGE , Ahicon3);
                break;
            case 3:
                // Lógica para el juego de Adivina el número
                JOptionPane.showMessageDialog(null, " Has seleccionado Adivina el número ",
                         "Adivina el número", JOptionPane.INFORMATION_MESSAGE , ANicon4);
                         adivinaElNumero();
                break;
            default:
                JOptionPane.showMessageDialog(null, "No has seleccionado ninguna opción");
                break;
             }
    }//metodo main

        // Método para el juego "Adivina el número." El programa debe generar un número aleatorio entre 0 y 100.
        // El jugador ingresa un número y el programa le informa si es mayor, menor o igual al número secreto.
        // Mantener el conteo de intentos del jugador.
        // Cuando el jugador adivine correctamente, mostrar el número de intentos que tomó.
        // Incluir opción para reiniciar el juego.
        // Implementar un sistema efectivo para comparar el número ingresado con el número objetivo.
        // Controlar los límites del rango (0 a 100) en la entrada del usuario.
        // Método para el juego "Adivina el número"
        
        public static void adivinaElNumero() {
            int numSecreto = (int) (Math.random() * 101); // Generar número aleatorio entre 0 y 100
            int intentos = 0 ;
            int numUsuario = -1 ;
            while (numUsuario != numSecreto) {
                String respuesta = JOptionPane.showInputDialog(null, " Adivina el número entre 0 y 100 : ");
                if (respuesta == null) {
                    JOptionPane.showMessageDialog(null, " Juego cancelado ");
                    return;
                }
                try {
                    numUsuario = Integer.parseInt(respuesta);
                    if (numUsuario < 0 || numUsuario > 100) {
                        JOptionPane.showMessageDialog(null, "Por favor, introduce un número entre 0 y 100");
                        continue;
                    }
                    intentos++;
                    if (numUsuario < numSecreto) {
                        JOptionPane.showMessageDialog(null, "El número es mayor");
                    } else if (numUsuario > numSecreto) {
                        JOptionPane.showMessageDialog(null, "El número es menor");
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Felicidades! Has adivinado el número en " + intentos + " intentos.");
                        int reiniciar = JOptionPane.showConfirmDialog(null, "¿Quieres jugar de nuevo?", "Reiniciar juego", JOptionPane.YES_NO_OPTION);
                        if (reiniciar == JOptionPane.YES_OPTION) {
                            adivinaElNumero(); // Reiniciar el juego
                        } else {
                            JOptionPane.showMessageDialog(null, "Gracias por jugar");
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido");
                }
            }
        } //class4
} //class









